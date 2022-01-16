pipeline {

    agent any

    environment{
              DOCKERHUB_CREDENTIALS = 'docker'
    }

    stages {
        stage("Build") {
            steps {
                echo 'building...'
                withGradle(){
                sh './gradlew build'
                }
            }
    }

//        stage('SonarQube analysis') {
//            steps {
//                withSonarQubeEnv('Sq') {
//                      sh './gradlew sonarqube'
//                }
//            }
//        }
      stage ('Build docker'){
        steps{
            sh 'docker build -t kurtev95/final-project:latest .'
        }
      }

      stage ('Login'){
        steps{
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        }
      }

      stage ('Push to DOCKER'){
        steps{
            sh 'docker push kurtev95/final-project:latest'
        }
      }

//       stage('Push and update container') {
//
//           steps {
//                        script {
//
//                            def customImage = docker.build("project:latest")
//                            docker.withRegistry('http://docker:5000') {
//                                customImage.push("latest")
//                            }
//                        }
//                        sshagent(credentials: ['docker-server']) {
//                            sh 'ssh -o StrictHostKeyChecking=no appolica@docker docker pull docker:5000/higgle'
//                            sh 'ssh -o StrictHostKeyChecking=no appolica@docker \'cd docker-compose-higgle && docker-compose up -d\''
//                        }
//                    }
//        }
    }
}
