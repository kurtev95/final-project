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
                    echo "test ${env.SONAR_HOST_URL}"
                    sh './gradlew sonarqube'
               }
           }
       }
    }
}
