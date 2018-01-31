#!/usr/bin/env groovy

def execute() {
  echo("${env.WORKSPACE}/stages/test.groovy")
  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
  }
}

return this
