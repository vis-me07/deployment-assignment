pipeline {
    agent any
    stages{
        stage('Code Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/vis-me07/deployment-assignment.git'
            }
        }
        stage('SonarQube Report') {
            steps {
                withSonarQubeEnv(installationName: 'sonar') {
                    sh 'gradle sonarqube'
                    sleep 60;
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("Build") {
            steps {
                sh 'gradle build'
            }
        }
        stage('Publish over ssh') {
            steps([$class: 'BapSshPromotionPublisherPlugin']) {
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName:"deployment-ssl-server",
                            verbose: true,
                            transfers:[
                                sshTransfer(
                                    sourceFiles:"**/build/libs/*.jar",
                                    remoteDirectory:"",
//                                     execCommand:"nohup java -jar target/*.jar &"
                                )
                            ]
                        )
                    ]
                )
            }
        }
    }
}