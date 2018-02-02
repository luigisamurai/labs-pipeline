#!/usr/bin/env groovy

def execute(pipelineProperties) {

  def pipelineParameter =  string(
      name: 'MY_VARIABLE',
      description: 'Pipeline Environment Config key',
      defaultValue: ''
  )

  for (index = 0; index < pipelineProperties.size(); index++) {
    println pipelineProperties[index].toString()
  }
  
  // pipelineProperties[0]
  // properties(pipelineProperties)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.MY_CUSTOM_PROP}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
