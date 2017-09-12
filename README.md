Homework 5
=========

### Due Friday, September 22, 2017 - 5:00PM

In this homework, you will practice using the following:

- Inheritance
- JSON

:warning: The test cases for this homework will not compile until you have implemented the classes specified below.

### JSON

For this assignment, you will first need to familiarize yourself with [Javascript Object Notation](https://en.wikipedia.org/wiki/JSON) (JSON) and the [GSON](https://github.com/google/gson) [API](https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.1).

Please refer to the in-class code examples for more information.

## Requirements

You will implement objects to represent the following types of people associated with USF: `Undergraduate`, `Graduate`, and `Faculty`.

### Undergraduate

The following JSON document represents an undergraduate student. An undergraduate must have all four elements show in the document below.

```json
{  
   "name":"Jenny",
   "id":20398776,
   "gpa":3.4,
   "year":"Junior"
}	
```
	
### Graduate

The following JSON document represents an graduate student. A graduate must have all four elements show in the document below.

```json
{  
   "name":"Jenny",
   "id":20398776,
   "gpa":3.4,
   "undergrad_uni":"Mills College"
} 
```
 
### Faculty
The following JSON document represents a faculty member. A faculty member must have all four elements show in the document below.

```json
{  
   "name":"Jenny",
   "id":20398776,
   "salary":108765
}
```

### Base Classes
All types of people derive from `Don` -- the base class provided for you. This `abstract` class is also `Comparable`, which means it must implement a `compareTo` method. `Don` objects are sorted alphabetically by their `name`. If two `Don` objects have the same `name` then they are sorted by `id`, smallest to largest. 

`Undergraduate` and `Graduate` are also `Student`. Make sure that `Don` stores any data common to all people, and that `Student` stores data common to both `Graduate` and `Undergraduate`.

### DonBuilder

The `buildDon` method of `DonBuilder` will take as input a `JsonObject` formatted as described above and will instantiate and return the appropriate subclass. 

The type of object instantiated will be dependent upon the elements contained in the `JsonObject`. Make sure to do appropriate error checking as described in the method javadoc.

### Other requirements
Your grade will depend upon whether you pass the test cases as well as on how well you use Java inheritance mechanisms. 

1. Make sure to use abstract classes and/or methods where appropriate.
2. Make sure to use the private/public/protected keywords appropriately.

### Submission Requirements

1. Use the following link to create your private github repository for this assignment. The repository will be seeded with the skeleton code, test cases, and input files. [Homework 5](https://classroom.github.com/a/eKOOqsIf)
2. For full credit, make sure to follow all [Style Guidelines](https://github.com/CS514-F17/notes/blob/master/Admin/style.md). Points will be deducted for each violation.

### Grading Rubric

| Points | Criterion | Description |
| ------ | -------- | -------- |  
| 3 | testUndergraduate | Code passes all test cases. |
| 3 | testGraduate | Code passes all test cases. |
| 4 | testFaculty | Code passes all test cases. |
| 4 | testUndergradInheritsStudent | Code passes all test cases. |
| 4 | testGradInheritsStudent | Code passes all test cases. |
| 4 | testInvalidTypeForId | Code passes all test cases. |
| 4 | testMissingId | Code passes all test cases. |
| 4 | testInvalidTypeForSalary | Code passes all test cases. |
| 5 | testCompareTo | Code passes all test cases. |
| 10 | Design  | Code is well designed and follows all specifications. |
| 5 | Style | Code follows all style guidelines. |

Partial credit may be awarded for partial functionality and/or partially correct design or style elements.

### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are required to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.
