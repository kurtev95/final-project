pipeline {
  
    agent any
  
    stages {
        stage("Build") {
            steps {
                echo 'building...'
                withGradle(){
                sh './gradlew build'
                }
            }
        }

       stage('SonarQube analysis') {

            environment {
                    scannerHome = tool 'Sq'
            }
           steps {
               withSonarQubeEnv('Sq') {
                    sh '${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=develop'
//                     sh './gradlew sonarqube'
               }
           }
       }
    }
}
