pipeline {

    agent any

    stages {
        stage("Build") {
            steps {
                withGradle(){
                sh './gradlew build'
                             }
                   }
            }

        stage("Tests") {
            steps {
                withGradle(){ sh './gradlew test'}
                   }
            }

//        stage('SonarQube analysis') {
//            steps {
//                withSonarQubeEnv('Sq') {
//                      sh './gradlew sonarqube'
//                }
//            }
//        }

      stage ('Build docker image'){
        steps{
            sh 'docker build -t kurtev95/final-project:1.0 .'
        }
      }

      stage ('Push docker image'){
        steps{
          withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'password', usernameVariable: 'username')]) {
              sh "docker login -u $username -p $password"
          }
             sh 'docker push kurtev95/final-project:latest'
          }
      }
    }
}
