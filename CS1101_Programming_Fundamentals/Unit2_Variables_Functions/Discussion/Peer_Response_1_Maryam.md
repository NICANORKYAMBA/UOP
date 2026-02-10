# CS1101 Unit 2 Discussion - Peer Response to Maryam Garba

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 2 - Variables, Expressions, Statements, and Functions  
**Date**: February 2026

---

## Peer Response to Maryam Garba

Hi Maryam,

Excellent work on your discussion post! Your examples clearly demonstrate the fundamental concepts of Python functions, parameters, arguments, and variable scope. I particularly appreciated how you structured each example with clear explanations and actual error outputs, which makes the concepts much easier to understand.

Your Example 2 showcasing the three types of arguments (value, variable, and expression) was especially well-executed. The progression from "Amina" as a literal value, to `username` as a variable, and finally to `"Mrs " + "Firdaus"` as an expression argument effectively illustrates how Python's flexibility allows different data sources to be passed into functions. This demonstrates what Downey (2015) describes as Python's ability to evaluate expressions before passing results to functions, a concept that's crucial for understanding how function calls work internally.

I found your Examples 3 and 4 particularly instructive because they both resulted in `NameError` exceptions, clearly demonstrating the boundaries of variable scope. Your explanation that "score only exists inside the function's scope" in Example 3 is spot-on. Similarly, your observation that parameters like `user_age` are "local to the function" reinforces the principle that parameters are essentially local variables created when the function is called and destroyed when it returns (Downey, 2015, p. 27). This encapsulation is fundamental to writing modular, maintainable code.

Your Example 5 on variable shadowing is excellent. The demonstration that the global `count` remains 10 while the local `count` inside the function is 5 perfectly illustrates how Python's scoping rules prevent accidental modification of global state. As you correctly noted, "Python treats them as two separate variables because they exist in different scopes." This behavior is what makes functions predictable and safe to use—they can't accidentally corrupt data outside their scope unless explicitly designed to do so.

Regarding your discussion question about when global variables might be justified, I'd add that global variables can be appropriate for application-wide configuration settings (like database connection strings or API keys), constants that never change (like mathematical values such as PI), or shared state in small scripts where the overhead of passing parameters becomes cumbersome. However, as programs grow larger, even these use cases are often better handled through classes, modules, or configuration files to maintain the benefits of encapsulation that you've so clearly demonstrated in your examples.

Your post effectively shows how Python's scope system creates "walls" around functions, preventing unintended interactions between different parts of a program. This isolation is what allows developers to write and test functions independently, knowing they won't accidentally interfere with other code—a principle that becomes increasingly valuable as programs scale in complexity.

Great work demonstrating these foundational concepts with practical, executable examples!

---

**Word Count**: 448 words

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
