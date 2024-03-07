def call() {
    pipeline {
        agent any
         // stages {
         //     stage('Git Checkout') {
         //         steps {
         //             script {
         //                 git branch: 'node-dev', url: 'https://github.com/Neel198910/tas.git'
         //             }
         //         }
         //    }
            stage ('Build') {
                steps {
                    script {
                        sh 'npm install'
                    }
                }
            }
            // stage ('SonarQube Analysis') {
            //     steps {
            //         script { 
            //             def scannerHome = tool 'sonarscanner4'
            //             withSonarQubeEnv('sonar-pro') {
            //                 sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=node.js-app"
            //             }
            //         }
            //     }
            // }
            stage('Docker Build Images') {
                steps {
                    script {
                        sh 'docker build -t goutham/multi:v6 .'
                        sh 'docker images'
                        sh 'docker ps'
                    }
                }
            }
            // stage('Docker Push') {
            //     steps {
            //         script {
            //             withCredentials([string(credentialsId: 'dockerPass', variable: 'dockerPassword')]) {
            //                 sh "docker login -u goutham -p ${dockerPassword}"
            //                 sh 'docker push goutham/multi:v2'
            //                 sh 'docker rmi goutham/multi:v2'
            //             }
            //         }
            //     }
            // }
            // stage('Deploy on k8s') {
            //     steps {
            //         script {
            //             withKubeCredentials(kubectlCredentials: [[ credentialsId: 'kubernetes', namespace: 'ms' ]]) {
            //                 sh 'kubectl apply -f kube.yaml'
            //                 sh 'kubectl get pods -o wide'
            //             }
            //         }
            //     }
            // }
        }
    }
}
