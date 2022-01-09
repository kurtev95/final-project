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
        withSonarQubeEnv() { // Will pick the global server connection you have configured
          sh './gradlew sonarqube'
        }
      }
    }
}
