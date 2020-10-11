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
 
   - **Name**: Name of Project
    - Example:
        - Name: MyFirstJavaProject
   - **Location**: Directory where the project will be created
    - Example:
        - Location: ~/Desktop/TEMP/MyFirstDL4JProject
   - **GroupId**: Reverse domain name of the organization. The purpose of GroupId is to makes the project recognizable across all available projects.
       - Example:
           - GroupID: ai.certifai
   - **ArtifactId**: Name of Artifact. By default same with the name of the project
    - Example:
        - Name: MyFirstJavaProject
   - **Version**: Version of the project. Default value is 1.0-SNAPSHOT
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

- The fundamental component to manage dependencies is by using **pom.xml - project object model (POM)**. 
- Simply put, _pom.xml_ is an XML representation of a Maven project with default values of configurations for dependencies name, version and etc.  

### 2.1 Single-Module Java Project

- Note:
  A module in Java represents a group of closely related packages and resources.  

- With pom.xml, dependency management is easy in defining, creating and maintaining reproducible environments with well-defined classpaths and library versions.

<p align="center">
  <img src="metadata/pom_1.png">
</p> 

- Let's take a look at a bare bone pom.xml.  

<p align="center">
  <img src="metadata/simplest_pom.png">
</p>  


### 2.2 Maven Central Repository

- Maven Central Repository hosted on the cloud.

<p align="center">
  <img src="metadata/maven_graphic_0.jpg">
</p>  

- Maven contains a huge number of commonly used libraries to be used by the community.  
- A library in Java is represented as a jar package.

<p align="center">
  <img src="metadata/maven_graphic_1.jpg">
</p>  

### 2.3 Add dependencies to _my-first-dl4j-project_ :man_technologist: :woman_technologist:

1. Search for javacv-platform in [central repository](https://mvnrepository.com/repos/central)
<p align="center">
  <img src="metadata/dependency_0.jpg">
</p>

- Search for javacv-platform

<p align="center">
  <img src="metadata/dependency_1.jpg">
</p>   

- Click into the version desired

<p align="center">
  <img src="metadata/dependency_2.jpg">
</p>  

2. Copy the code snippet under the _dependencies_ of pom.xml. 
<p align="center">
  <img src="metadata/dependency_3.jpg">
</p>  

Paste the code snippets in the root pom.xml of your newly build project.

 <p align="center">
   <img src="metadata/pom_.jpg">
 </p>  

3. Paste these code snippets in the [**App.java**](https://gist.github.com/codenamewei/4bfe8251c2ddfb0e84db2dc3f5a37c9c)

4. Reload project
<p align="center">
  <img src="metadata/reload.jpg">
</p> 
   - You can check the folder _.m2_ that the corresponding jar file has been downloaded from central repository.   

 <p align="center">
   <img src="metadata/m2.jpg">
 </p>  

5. Run the program

### How does **2.3** works?

_.m2_ folder in the host system saved local repositories.  
If a particular dependency not found in the folder, Maven would check _.m2_ folder to make sure all dependencies exists locally.
Else, Apache Maven would download the dependency from the cloud by referring to pom.xml.

<p align="center">
  <img src="metadata/maven_graphic_2.jpg">
</p>  

### 2.4 Multi-Modules Project :man_technologist: :woman_technologist:

- Multi modules project is more complex compared to single module project.  
- There's a root pom.xml for the whole repository and a child pom.xml per module.  
    -  The root pom.xml in the root folder provide information which is leverage in every child module. 
    
<p align="center">
  <img width="350" height="400" src="metadata/pom_2.png">
</p>  

:question: 
How many pom.xml is in the [**TrainingLabs**](https://github.com/CertifaiAI/TrainingLabs.git) repository? 
  
### Chapter 3 Useful day-to-day operations with Apache Maven & Intellij :man_technologist: :woman_technologist:

**Note 1: When importing a Maven project into Intellij, open a new project pointing to the root pom.xml.  **

Step 1: Import an existing project

- There's two approaches in importing an existing project. 
  First of all, open Intellij in your host system. 

1. (Option 1) Click "Open or Import" in the "Welcome to IntelliJ IDEA" interface. 
<p align="center">
  <img src="metadata/import0.jpg">
</p>  

1. (Option 2) If there's an existing project opened, create a new project by going to **File -> New -> Project from Existing Sources**
<p align="center">
  <img src="metadata/import_1.jpg">
</p>  

2. Select the root pom.xml of the repository in which intend to open in Intellij.
<p align="center">
  <img src="metadata/import_2.jpg">
</p>  

**Note 2 When the IDE is not behave like what you are expecting,  
one of the few debugging steps an individual can try to do is clear the cache and restart to see if it solves the problem. **
<p align="center">
  <img src="metadata/invalidate.jpg">
</p>  

**Note 3: The changes in pom.xml will not automatically be reflected when the program is run**.  
- Always remember to reload the project once make changes to any of the pom.xml.  

1. Right click on the repository name. Find **Maven -> Reimport** from the categories.  
    - In some system, it's **Maven -> Reload project**. Both serves the same purpose.
<p align="center">
  <img src="metadata/reload.jpg">
</p>  

## **Quiz** 
- How to create a maven project in intellij in the most convenient way?