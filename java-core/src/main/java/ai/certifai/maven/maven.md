# Gist of Java with Apache Maven

## Chapter 1 Introduction of Apache Maven

### 1.1 Installation of Apache Maven :man_technologist: :woman_technologist:

- Download and install Apache Maven from [here](https://maven.apache.org/download.cgi).  

- Verify the installation through 
```
mvn -version
```
<p align="center">
  <img width="500" height="350" src="metadata/maven_0.png">
</p>  

### 1.2 What is Apache Maven

- Apache Maven is a **project management tool** primarily for Java projects. 

- Apache Maven manage a project's build, reporting and documentation from a central piece of information, pom.xml - project object model (POM). 

- This folder covers some of the Maven essentials to manage Java based project in day to day use.

### 1.3 Build an Apache Maven Project :man_technologist: :woman_technologist:

Step 1: Create a new project in Intellij

- There's two approaches in creating new project. 
  First of all, open Intellij in your host system. 

1. (Option 1) Click "Create New Project" in the "Welcome to IntelliJ IDEA" interface. 
<p align="center">
  <img src="metadata/maven_create_project_0_0.png">
</p>  

1. (Option 2) If there's an existing project opened, create a new project by going to **File -> New -> Project**
<p align="center">
  <img src="metadata/maven_create_project_0.png">
</p>  

2. Choose the archetype **maven-archetype-quickstart** to start with.  
   :information_source: maven-archetype-quickstart is sample Maven template which provides skeleton structure of Java project.
<p align="center">
  <img src="metadata/maven_create_project_1.png">
</p>  

3. Fill up the bottom fields accordingly.  
 
   - Name: Name of Project
    - Example:
        - Name: MyFirstJavaProject
   - Location: Directory where the project will be created
    - Example:
        - Location: ~/Desktop/temp
   - GroupId: Reverse domain name of the organization. The purpose of GroupId is to makes the project recognizatble across all available projects.
       - Example:
           - GroupID: ai.certifai
   - ArtifactId: Name of Artifact. By default same with the name of the project
    - Example:
        - Name: MyFirstJavaProject
   - Version: Version of the project. Default value is 1.0-SNAPSHOT
    - Example:
        - Version: 1.0-SNAPSHOT
                   
<p align="center">
  <img src="metadata/maven_create_project_2.png">
</p>

:information_source: These information can be modified at later phase.

:information_source: The properties of the project can be double checked in this interface during creating project.  
<p align="center">
  <img src="metadata/maven_create_project_3.png">
</p>


## Chapter 2 Dive in Java with Apache Maven

- The fundamental component to manage dependencies is by using pom.xml - project object model (POM). 
- Simply put, _pom.xml_ is an XML representation of a Maven project with default values of configurations for dependencies name, version and etc.  
- Let's take a look at a bare bone pom.xml.  

<p align="center">
  <img width="500" height="350" src="metadata/simplest_pom.png">
</p>  

### Single-Module Java Project

- Note:
  A module in Java represents 
  
- A single-module project 

- With pom.xml, dependency management is easy in defining, creating and maintaining reproducible environments with well-defined classpaths and library versions.

<p align="center">
  <img width="490" height="400" src="metadata/pom_1.png">
</p>  

### repository and dependency download

- root pom.xml


### group id and name and dependency


### Multi-Modules Project

<p align="center">
  <img width="350" height="400" src="metadata/pom_2.png">
</p>  


  - root and sub pom.xml
  
### Chapter 3 Useful hacks of Apache Maven with Intellij


### import by pom.xml

### .m2

- what is .m2
- how to find jar files

### invalidate cache and restart

### Reimport project after change of pom.xml
