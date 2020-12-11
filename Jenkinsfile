node{
    stages {
         stage('Stat') {
            sh 'echo "starting ..."'
         }
         stage ('scm checkout git project') {
            git 'https://github.com/atlroc99/jenkins-pipeline-docker.git'
         }
         stage ('maven compile project') {
            sh 'mv clean package'
         }

         stage('END') {
                 sh 'echo "Ending ..."'
         }
    }
}