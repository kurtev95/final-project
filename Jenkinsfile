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
           steps {
               withSonarQubeEnv('Sq') {
                    sh "./gradlew sonarqube"
               }
           }
       }
    }
}
