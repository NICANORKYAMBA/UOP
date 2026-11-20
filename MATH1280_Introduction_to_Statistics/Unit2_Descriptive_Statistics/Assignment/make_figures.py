#!/usr/bin/env python3
"""Draws the Question 2 stem-and-leaf plot, histogram and box plot into figures/."""
import statistics as st
from pathlib import Path

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

OUT = Path(__file__).resolve().parent / "figures"
SCORES = [72, 88, 94, 119, 85, 91, 77, 84, 75, 79, 83, 80, 87, 70, 76, 82, 93, 78, 89, 95, 86, 90, 73, 92, 81]
data = sorted(SCORES)
n = len(data)
median = st.median(data)
q1, q3 = st.median(data[: n // 2]), st.median(data[n // 2 + 1:])  # halves exclude the median (OpenStax method)
iqr = q3 - q1
low_fence, high_fence = q1 - 1.5 * iqr, q3 + 1.5 * iqr
outliers = [x for x in data if x < low_fence or x > high_fence]
BLUE, RED = "#1f5aa6", "#c0392b"

# Figure 1: stem-and-leaf plot
stems = {s: [x % 10 for x in data if x // 10 == s] for s in range(data[0] // 10, data[-1] // 10 + 1)}
fig, ax = plt.subplots(figsize=(6.2, 3.4), dpi=200)
ax.axis("off")
ax.set_xlim(0, 1)
ax.set_ylim(0, 1)
ax.text(0.10, 0.93, "Stem", fontsize=12, fontweight="bold", family="DejaVu Sans Mono", ha="right")
ax.text(0.16, 0.93, "Leaf", fontsize=12, fontweight="bold", family="DejaVu Sans Mono")
ax.plot([0.13, 0.13], [0.12, 0.98], color="black", lw=1.2)
for k, (stem, leaves) in enumerate(stems.items()):
    y = 0.78 - k * 0.15
    ax.text(0.10, y, str(stem), fontsize=12, family="DejaVu Sans Mono", ha="right")
    for j, leaf in enumerate(leaves):
        is_out = stem * 10 + leaf in outliers
        ax.text(0.16 + j * 0.06, y, str(leaf), fontsize=12, family="DejaVu Sans Mono",
                color=RED if is_out else "black", fontweight="bold" if is_out else "normal")
    if any(stem * 10 + leaf in outliers for leaf in leaves):
        ax.text(0.26, y, "<- 119, potential outlier", fontsize=10, color=RED)
ax.text(0.02, 0.02, "Key: 7 | 2 = 72 points. Stem 10 has no leaves (no scores from 100 to 109).", fontsize=9.5, style="italic")
fig.tight_layout()
fig.savefig(OUT / "fig1_stem_and_leaf.png")

# Figure 2: histogram with class width 10 (70-79, 80-89, ...)
fig, ax = plt.subplots(figsize=(6.5, 3.8), dpi=200)
bins = list(range(70, 130, 10))
counts, _, patches = ax.hist(data, bins=bins, edgecolor="black", color=BLUE, rwidth=1.0, zorder=3)
patches[-1].set_facecolor(RED)
for left, c in zip(bins, counts):
    if c:
        ax.text(left + 5, c + 0.2, f"{int(c)}", ha="center", fontsize=10)
ax.annotate("Potential outlier (119)", xy=(115, 1), xytext=(101, 6.0), color=RED, fontsize=10,
            arrowprops=dict(arrowstyle="->", color=RED))
ax.set_xticks(bins)
ax.set_xlabel("Test score (classes of width 10; lower limit included)")
ax.set_ylabel("Frequency (number of students)")
ax.set_ylim(0, 11.5)
ax.grid(axis="y", linestyle=":", alpha=0.6, zorder=0)
for side in ("top", "right"):
    ax.spines[side].set_visible(False)
fig.tight_layout()
fig.savefig(OUT / "fig2_histogram.png")

# Figure 3: box plot with 1.5 x IQR fences
fig, ax = plt.subplots(figsize=(6.5, 2.9), dpi=200)
ax.boxplot(data, vert=False, whis=1.5, widths=0.5, patch_artist=True,
           boxprops=dict(facecolor="#dbe8f7", edgecolor="black"), medianprops=dict(color=RED, lw=2),
           flierprops=dict(marker="o", markersize=8, markerfacecolor=RED, markeredgecolor="black"))
labels = ((min(data), "Min = 70", 1.30), (q1, f"Q1 = {q1:g}", 1.46), (median, f"Median = {median:g}", 1.30),
          (q3, f"Q3 = {q3:g}", 1.46), (max(x for x in data if x not in outliers), "Max = 95", 1.30))
for value, label, y in labels:
    ax.text(value, y, label, ha="center", fontsize=9)
ax.text(119, 1.30, "119: potential\noutlier", ha="center", fontsize=9, color=RED)
ax.axvline(high_fence, color="gray", linestyle="--", lw=1)
ax.text(high_fence - 0.6, 0.55, f"Upper fence = Q3 + 1.5 × IQR = {high_fence:g}", ha="right", fontsize=8, color="gray")
ax.set_yticks([])
ax.set_xlim(65, 125)
ax.set_ylim(0.45, 1.6)
ax.set_xlabel("Test score")
for side in ("top", "right", "left"):
    ax.spines[side].set_visible(False)
fig.tight_layout()
fig.savefig(OUT / "fig3_box_plot.png")

print(f"n={n} median={median} Q1={q1} Q3={q3} IQR={iqr} fences=({low_fence}, {high_fence}) outliers={outliers}")
print("histogram counts", dict(zip(bins, counts)))
