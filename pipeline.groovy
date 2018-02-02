#!/usr/bin/env groovy

def execute(pipelineProperties) {
        println pipelineProperties.getClass()
        
        def abcd = parameters ([
        string(
            name: 'PIPELINE_ENV_DEFAULT',
            description: 'Specify the environment to be run, by default it executes stg. for example: qa, stg, prod, onprem, eu',
            defaultValue: 'stgXDR.....'
        )
    ])
    
    pipelineProperties.add(abcd)
  
  properties(pipelineProperties)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.MY_CUSTOM_PROP}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
