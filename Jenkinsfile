node {
    stage('scm checkout git project') {
        git 'https://github.com/atlroc99/jenkins-pipeline-docker.git'
    }
    stage('maven build docker image') {
        //using as variable in the mvn build command
        def MAVEN_HOME = tool name: 'jenkins-maven', type: 'maven'
        sh "${MAVEN_HOME}/bin/mvn clean package -DskipTests=true"
    }
    stage('deploy / run docker container') {
//           docker run -d --name container_name image_name
        sh '''
            echo "stop and removing demo-service if running"
            docker stop demo-service || true && docker rm demo-service || true
            docker run -d -p 8090:8090 --name demo-service demo:latest
           '''
    }
}