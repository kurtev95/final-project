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
                    sh '${scannerHome}/bin/sonar-scanner --version'
                    echo "-----------------------------------------------"
                    sh '${scannerHome}/bin/sonar-scanner'
//                     sh './gradlew sonarqube'
               }
           }
       }
    }
}
