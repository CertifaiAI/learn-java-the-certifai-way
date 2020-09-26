# Construction of Class

## **Background**
### Analogy 1: Cloning
 <p align="center">
   <img width="300" height="400" src="metadata/cloning.gif">
 </p>  

### Analogy 2: Create identical items out of the blueprint design

 What is **blueprint**?  
 Reproduction of technical drawing to allow rapid and accurate production of an unlimited number of copies.


 <p align="center">
   <img width="550" height="400" src="metadata/spaceX.jpg">
 </p>  
 
  <p align="center">
    <img width="550" height="400" src="metadata/spaceXengine.jpg">
  </p>  
 

**What To Do**  
1. Uncomment 3 lines of code [_from line 45 to 47_](https://github.com/CertifaiAI/java-fundamentals/blob/master/java-core/src/main/java/ai/certifai/basic/ex3/BluePrint.java#L45-L47)  
2. Make the necessary addition of functions in the class [_PersonalProfile.class_]() to support item 1 to works.  

**Example Code**  
```
public {returning format} {function name}()      
{        
     return {variable name};      
}    
```


**Expected Output** 
```
Total Number: 1  
Name: John Doe  
Height: 165    
Width: 100   
```

**Key Takeaways**
- Did you changed the modifier of the variable _name_, _height_, _width_ to make it works? 

 <p align="center">
   <img src="metadata/public.png">
 </p> 
 
 # **Don't do it. Why?**
  <p align="center">
   <img src="metadata/tenor.gif">
 </p> 
 
 The **private**prevent outside entities from access the variables.  
 You can only deal with the **private** members through getter and setter functions. 
 
- Keyword **static**: It exists by default and can run by itself (at the class level without creating an object)

- **void**: Returns no value.  

- There are access modifiers to select on the class, package, function, variables level.  

| Access Modifiers | Function |
| --- | ----------- |
| public | Visible to everywhere. The method / variable can be called from anywhere from outside the program as well. |
| protected | The member can only be accessed by its own class, and subclass of its class in its own package  |
| private | The member can only be accessed by own class |
 


**Quiz** 

1. Is .java program equal to machine code?  
