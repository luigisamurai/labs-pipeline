#!/usr/bin/env groovy

@NonCPS
def execute(pipelineProperties) {
  // def abcd = parameters ([
  //       string(
  //           name: 'PIPELINE_ENV_DEFAULT',
  //           description: 'Specify the environment to be run, by default it executes stg. for example: qa, stg, prod, onprem, eu',
  //           defaultValue: 'stgXDR.....'
  //       )
  //   ])

  def item = string(
      name: 'PIPELINE_ENV_DEFAULT',
      description: 'Specify the environment to be run, by default it executes stg. for example: qa, stg, prod, onprem, eu',
      defaultValue: 'stgXDR.....'
  )
    
  // //   pipelineProperties.add(abcd)
  
  // // properties(pipelineProperties)

  def prop = []
  // def allParameters = []


  // allParameters.add(pipelineParameter)

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
        // prop.add(property.getArguments())
        // println property.getArguments()
        property.add(item)
        prop.add(property)

    } else {
      prop.add(property)
    }
  }

  // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
  // def allParameters = []
  // // def pipelineParameter =  string(
  // //   name: 'DEBUGER_BVAR',
  // //   description: 'Pipeline Environment Config key',
  // //   defaultValue: ''
  // // )

  // for(ParameterValue parameter in pipelineProperties[0]) {
  //   println parameter.name
  //   def item = string(
  //       name: parameter.name,
  //       description: parameter.description
  //   )
  //   allParameters.add(item)
  // }



  // for (ParametersDefinitionProperty property in pipelineProperties) {
  //   allParameters.add(property)
  // }

  // properties(pipelineProperties)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
