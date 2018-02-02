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
    
  //   pipelineProperties.add(abcd)
  
  // properties(pipelineProperties)

  def prop = []
  def allParameters = []
  def pipelineParameter =  string(
    name: 'DEBUGER_BVAR',
    description: 'Pipeline Environment Config key',
    defaultValue: ''
  )

  allParameters.add(pipelineParameter)

  for (ParametersDefinitionProperty property in pipelineProperties) {
    if ( property.toString().startsWith("@parameters") ) {
        // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
        // for(ParameterValue parameter in jenkinsfileParameters) {
        //   def item = string(
        //       name: parameter.name,
        //       description: parameter.description
        //   )
        //   allParameters.add(item)
        // }

        // properties([
        //     parameters(allParameters)
        // ])

        prop.add(property)
      
    } else {
      prop.add(property)
    }
  }

  properties(prop)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
