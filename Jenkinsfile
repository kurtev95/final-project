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
                    scannerHome = tool 'sonar_scanner'
            }
           steps {
               withSonarQubeEnv('Sq') {
                    echo '${scannerHome}/bin/sonar-scanner --version'
                    echo "test 11 ${env.SONAR_HOST_URL}"
                    sh './gradlew sonarqube'
               }
           }
       }
    }
}
