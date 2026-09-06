# GeoGebra Guide — Task 2 Graph: E(P) = P − 10000, P ≥ 10000

Goal: plot the export function E(P) = P − 10000 for P ≥ 10000, using a scale where
1 unit = 1000 on both axes, then screenshot it for the assignment.

Open GeoGebra: https://www.geogebra.org/calculator

---

## Option A — quickest (plot with the scale trick)

Because the instructions say "let 1 = 1000," we graph in *thousands*. So P in thousands is
your x, and E in thousands is your y. The function becomes **y = x − 10** for **x ≥ 10**
(since 10000/1000 = 10). Every unit on the graph then represents one thousand, exactly as
asked.

1. In the **Input bar** (left panel), type this and press Enter:

   ```
   f(x) = If(x >= 10, x - 10)
   ```

   - `If(x >= 10, x - 10)` draws the line **only for x ≥ 10**, matching the domain P ≥ 10000.
   - The graph starts at the point (10, 0) — which represents P = 10000, E = 0 — and rises
     to the right with slope 1.

2. (Optional, makes it clearer) mark the starting point. In the Input bar type:

   ```
   A = (10, 0)
   ```

3. Add axis labels so the grader sees the meaning:
   - Click the **Settings** (gear) → **Graphics** tab → set the **x-Axis label** to
     `P (thousands)` and the **y-Axis label** to `E (thousands)`. (Or just note it in your
     write-up: "each unit = 1000.")

4. Adjust the view so the important part shows: you want to see x from about 0 to 80 and y
   from about 0 to 70. Scroll/zoom (mouse wheel) until the line from (10, 0) upward is
   clearly visible. You should be able to see the points that matter: at x = 20 the line is
   at y = 10, and at x = 70 the line is at y = 60 (these are your Task 2(iv) answers:
   E(20000) = 10000 and E(70000) = 60000).

---

## Option B — literal values (if you prefer real numbers on the axes)

If you'd rather show the true numbers (10000, 70000) instead of the thousands scale:

1. Input bar:

   ```
   f(x) = If(x >= 10000, x - 10000)
   ```

2. Then rescale the axes so large numbers fit: Settings (gear) → Graphics → set
   **x Min = 0, x Max = 80000, y Min = 0, y Max = 70000** (or right-click the graphics view
   → zoom out until you can see up to ~80000).

3. This shows the same ray starting at (10000, 0). It's mathematically identical to Option
   A; only the axis numbers differ.

> The assignment explicitly says "use a scale where each unit represents one thousand," so
> **Option A is the better match** for the instructions. Just mention in your write-up that
> 1 unit = 1000.

---

## Screenshot and insert

1. Once the graph looks clean (line starting at the P = 10000 point, rising to the right),
   take a screenshot:
   - GeoGebra has its own export: **menu (three lines) → Download / Export Image → PNG**.
   - Or use Flameshot to grab just the graphics panel.
2. Open `Unit1_Assignment_Activity.docx`, click the line
   **[ Insert GeoGebra graph of E(P) here ]** (under Task 2), and insert the image
   (Insert → Pictures, or paste).

That's the only image the assignment strictly requires — Tasks 1, 3, and 4 are answered from
the graphs already given to you, so they don't need new GeoGebra plots (though you may add
them if you want extra polish).
