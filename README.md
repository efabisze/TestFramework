# TestFramework

After cloning, must add selenium JAR to project structure
- Update selenium as needed
Go to download testng jar : https://mvnrepository.com/ 
- Choose the JAR and download 
Change build.gradle file 
For Example:
plugins {
    id 'java'
}

group 'org.example'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    compile (       ['org.seleniumhq.selenium:selenium-java:4.3.0'],
                    ['org.testng:testng:7.6.0']
            )
}

test {
    useTestNG()
}
