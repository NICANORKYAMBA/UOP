#!/usr/bin/env python3
"""
Independent check of stackapp.asm.

Assembles and links the program, then runs it on thousands of random strings
and compares every line it prints with a Python reference version of the same
three algorithms (reverse, palindrome, bracket check). Lengths around the
64-character stack limit are tested on purpose.

Usage: python3 verify_stackapp.py
"""

import random
import subprocess
import tempfile
from pathlib import Path

HERE = Path(__file__).resolve().parent
STACK_MAX = 64
PAIRS = {")": "(", "]": "[", "}": "{"}


def expected(text):
    """What stackapp should print for one input string."""
    lines = [f'Input      : "{text}"']
    if len(text) > STACK_MAX:
        lines.append("Reversed   : error: stack overflow, the string is longer than 64 characters")
        lines.append("Palindrome : skipped, the string could not be reversed")
    else:
        rev = text[::-1]
        lines.append(f'Reversed   : "{rev}"')
        lines.append("Palindrome : " + ("yes" if rev == text else "no"))

    stack, result = [], None
    for pos, ch in enumerate(text, start=1):
        if ch in "([{":
            if len(stack) == STACK_MAX:
                result = "error: stack overflow, more than 64 open brackets"
                break
            stack.append(ch)
        elif ch in PAIRS:
            if not stack:
                result = f"NOT balanced: '{ch}' at position {pos} has no opening bracket"
                break
            top = stack.pop()
            if top != PAIRS[ch]:
                result = f"NOT balanced: '{ch}' at position {pos} does not match '{top}'"
                break
    if result is None:
        result = "balanced" if not stack else f"NOT balanced: {len(stack)} bracket(s) never closed"
    lines.append("Brackets   : " + result)
    return lines + [""]


def build(workdir):
    obj, exe = workdir / "stackapp.o", workdir / "stackapp"
    subprocess.run(["nasm", "-f", "elf", str(HERE / "src" / "stackapp.asm"), "-o", str(obj)], check=True)
    subprocess.run(["ld", "-m", "elf_i386", str(obj), "-o", str(exe)], check=True)
    return exe


def random_case(rng):
    length = rng.choice([rng.randint(0, 12), rng.randint(60, 70), rng.randint(0, 80)])
    alphabet = rng.choice(["()", "()[]{}", "()[]{}ab ", "ab", "([{"])
    if rng.random() < 0.2:  # build a palindrome on purpose
        half = "".join(rng.choice(alphabet) for _ in range(length // 2))
        return half + rng.choice(["", "x"]) + half[::-1]
    return "".join(rng.choice(alphabet) for _ in range(length))


def main():
    rng = random.Random(1105)
    cases = ["", "Assembly", "racecar", "(a + b) * [c - d]", "{[()()]}", "([)]", "((x)", "x)(",
             "(" * 64, "(" * 65, "a" * 64, "a" * 65, "()" * 32, "()" * 33]
    cases += [random_case(rng) for _ in range(5000)]

    with tempfile.TemporaryDirectory() as tmp:
        exe = build(Path(tmp))
        failures = 0
        for start in range(0, len(cases), 200):  # 200 strings per run
            batch = cases[start:start + 200]
            out = subprocess.run([str(exe), *batch], capture_output=True, text=True, check=True).stdout
            got = out.split("\n")[2:]  # skip the title and blank line
            want = [line for text in batch for line in expected(text)]
            if got[:len(want)] != want:
                failures += 1
                for g, w in zip(got, want):
                    if g != w:
                        print("MISMATCH\n  got :", g, "\n  want:", w)
                        break

    print(f"Checked {len(cases)} strings against the Python reference: "
          f"{'all match' if failures == 0 else f'{failures} batch(es) failed'}")


if __name__ == "__main__":
    main()
