#!/usr/bin/env python3
"""
Builds the practice page from practice_template.html and practice_questions.json.

Output: MATH1201_Final_Practice.html          (for publishing; the host adds the page skeleton)
        MATH1201_Final_Practice_offline.html  (complete page to open straight from disk)

Run build_study_guide.py first so practice_questions.json is current.
"""

import json
from pathlib import Path

from question_bank import UNIT_NAMES

HERE = Path(__file__).resolve().parent


def main():
    questions = json.loads((HERE / "practice_questions.json").read_text())
    page = (HERE / "practice_template.html").read_text()
    page = page.replace("__QUESTIONS__", json.dumps(questions, ensure_ascii=False))
    page = page.replace("__UNITS__", json.dumps({str(k): v for k, v in UNIT_NAMES.items()}, ensure_ascii=False))
    (HERE / "MATH1201_Final_Practice.html").write_text(page)

    split = page.index("</style>") + len("</style>")
    offline = ("<!doctype html>\n<html lang=\"en\">\n<head>\n<meta charset=\"utf-8\">\n"
               "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, viewport-fit=cover\">\n"
               "<style>[hidden]{display:none!important} body{margin:0}</style>\n"
               + page[:split] + "\n</head>\n<body>\n" + page[split:] + "\n</body>\n</html>\n")
    (HERE / "MATH1201_Final_Practice_offline.html").write_text(offline)
    print(f"Built both pages with {len(questions)} questions")


if __name__ == "__main__":
    main()
