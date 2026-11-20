#!/usr/bin/env python3
"""Draws NRZ-L, NRZ-I, Manchester and Differential Manchester waveforms for one bit pattern.

Conventions (stated in the figure note): NRZ-L 1 = high; NRZ-I 1 = transition at bit start;
Manchester (IEEE 802.3) 0 = high-to-low, 1 = low-to-high at mid-bit; Differential Manchester
always transitions mid-bit, 0 = extra transition at bit start, 1 = none.
"""
from pathlib import Path

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

BITS = [0, 1, 0, 0, 1, 1, 1, 0, 0, 0]


def nrz_l(bits):
    return [(i, b) for i, b in enumerate(bits)] + [(len(bits), bits[-1])]


def steps(levels):
    """levels: list of (time, level) change points -> x, y for a step plot."""
    xs, ys = [], []
    for (t, v), (t2, _) in zip(levels, levels[1:]):
        xs += [t, t2]
        ys += [v, v]
    return xs, ys


def waveform(bits, kind):
    pts = []
    level = 0
    for i, b in enumerate(bits):
        if kind == "NRZ-L":
            pts += [(i, b), (i + 1, b)]
        elif kind == "NRZ-I":
            if b == 1:
                level ^= 1
            pts += [(i, level), (i + 1, level)]
        elif kind == "Manchester":
            first, second = (0, 1) if b == 1 else (1, 0)
            pts += [(i, first), (i + 0.5, first), (i + 0.5, second), (i + 1, second)]
        elif kind == "Differential Manchester":
            if b == 0:
                level ^= 1          # transition at the start of a 0
            pts += [(i, level), (i + 0.5, level)]
            level ^= 1              # mandatory mid-bit transition
            pts += [(i + 0.5, level), (i + 1, level)]
    return zip(*pts)


kinds = ["NRZ-L", "NRZ-I", "Manchester", "Differential Manchester"]
fig, axes = plt.subplots(len(kinds), 1, figsize=(8, 6.2), dpi=200, sharex=True)
for ax, kind in zip(axes, kinds):
    x, y = waveform(BITS, kind)
    ax.plot(list(x), list(y), color="#1f5aa6", lw=2.2, drawstyle="default")
    ax.set_ylim(-0.35, 1.35)
    ax.set_yticks([0, 1])
    ax.set_yticklabels(["Low", "High"], fontsize=8)
    ax.set_ylabel(kind, rotation=0, ha="right", va="center", fontsize=10, fontweight="bold")
    for i in range(len(BITS) + 1):
        ax.axvline(i, color="gray", lw=0.6, ls=":")
    for side in ("top", "right"):
        ax.spines[side].set_visible(False)
for i, b in enumerate(BITS):
    axes[0].text(i + 0.5, 1.55, str(b), ha="center", fontsize=12, fontweight="bold")
axes[0].text(-0.15, 1.55, "Data:", ha="right", fontsize=11, fontweight="bold")
axes[-1].set_xlabel("Bit periods")
axes[-1].set_xticks(range(len(BITS) + 1))
fig.tight_layout()
out = Path(__file__).resolve().parent / "figures" / "fig1_line_coding.png"
fig.savefig(out)
print("Saved", out)
