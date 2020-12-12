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
    stage('Push docker image to ECR') {
        // LOGIN: aws ecr get-login-password --region region | docker login --username AWS --password-stdin aws_account_id.dkr.ecr.region.amazonaws.com
        //  1. docker tag e9ae3c220b23 aws_account_id.dkr.ecr.region.amazonaws.com/my-web-app
        // 2. docker push aws_account_id.dkr.ecr.region.amazonaws.com/my-web-app
        sh '''
            aws ecr get-login-password --region region | docker login --username AWS --password-stdin 429506819373.dkr.ecr.us-east-1.amazonaws.com
            docker tag demo:latest 429506819373.dkr.ecr.us-east-1.amazonaws.com/mz-cicd-demo
            docker push 429506819373.dkr.ecr.us-east-1.amazonaws.com/mz-cicd-demo
           '''
    }

}