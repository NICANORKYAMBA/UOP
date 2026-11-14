#!/usr/bin/env python3
"""Draws the Question 2 dot plot (one dot per family) to figures/fig1_dot_plot.png."""
from pathlib import Path

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

MEMBERS = [2, 3, 4, 5, 6, 7]
FAMILIES = [1, 4, 7, 6, 3, 2]

fig, ax = plt.subplots(figsize=(7, 4.2), dpi=200)
for x, n in zip(MEMBERS, FAMILIES):
    ax.scatter([x] * n, range(1, n + 1), s=140, color="#1f5aa6", edgecolor="black", zorder=3)
    ax.annotate(f"n = {n}", (x, n + 0.6), ha="center", fontsize=9)
ax.set_xticks(MEMBERS)
ax.set_xlim(1.4, 7.6)
ax.set_yticks(range(0, 9))
ax.set_ylim(0, 8.4)
ax.set_xlabel("Number of members in the household")
ax.set_ylabel("Number of families (one dot = one family)")
# APA 7: the figure title goes in the paper above the image, not inside it
ax.grid(axis="y", linestyle=":", alpha=0.6, zorder=0)
for side in ("top", "right"):
    ax.spines[side].set_visible(False)
fig.tight_layout()
out = Path(__file__).resolve().parent / "figures" / "fig1_dot_plot.png"
fig.savefig(out)
print("Saved", out, "| total families =", sum(FAMILIES), "| more than four =", sum(f for m, f in zip(MEMBERS, FAMILIES) if m > 4))
