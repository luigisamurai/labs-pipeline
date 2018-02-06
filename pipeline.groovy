#!/usr/bin/env groovy
import hudson.model.ParametersDefinitionProperty
import hudson.model.JobProperty

def execute(supportedEnvs, pipelineProperties = null) {
  // Codigo que ha funcionando
  // def defaultParameters =  [
  //     string(
  //     name: 'CUSTOM',
  //     description: 'Pipeline Environment Config key',
  //     defaultValue: 'CUSTOM---..'
  //   ),
  //   string(
  //     name: 'OTRO',
  //     description: 'OTRO',
  //     defaultValue: 'OTRO---..'
  //   )
  // ]

  // def allParameters = pipelineProperties[0].getArguments().get('<anonymous>')
  // allParameters.addAll(defaultParameters)

  // def prop = []
  // prop.add(
  //   parameters(
  //     allParameters
  //   )
  // )
  // prop.add(pipelineProperties[1])
  // prop.add(pipelineProperties[2])

  // properties(prop)

  // Codigo que ha funcionando

  // properties([
  //   parameters(
  //     allParameters
  //   ),
  //   pipelineProperties[1],
  //   pipelineProperties[2]
  // ])

  // esta trabajo aun mejor
  def prop = []
  def defaultParameters =  [
    choice(
      name: 'PIPELINE_ENV',
      description: 'Target environment',
      choices: supportedEnvs.split(',').join('\n'),
      value: 'prod'
    ),
    string(
      name: 'OTRO',
      description: 'OTRO',
      defaultValue: 'OTRO---..',
      required: true
    ),
    string(
      name: 'OTRO_MAS',
      description: 'OTRO_MAS',
      defaultValue: 'OTRO_MAS',
      required: true
    )
  ]

  def allParameters = defaultParameters)

  for (ParametersDefinitionProperty property in pipelineProperties) {
      if (property.toString().startsWith("@parameters")) {
        def jenkinsfileParameters = property.getArguments().get('<anonymous>')
        // LinkedHashMap
        // Set set = property.getArguments().entrySet();
        // Iterator iterator = set.iterator();   
        // while(iterator.hasNext()) {
        //   Map.Entry me = (Map.Entry)iterator.next();
        //   println "Key is: "+ me.getKey() + 
        //             "& Value is: "+me.getValue().getName()+"\n";
        // }
        
        // def defaultNamesParameters = []
        // for(defualtIndex = 0; defualtIndex < defaultParameters.size(); defualtIndex ++) {
        //   defualtParameter = defaultParameters.get(defualtIndex).getArguments()
        //   defaultNamesParameters.add(defualtStringParameter.name)
        // }

        // for(index = 0; index < jenkinsfileParameters.size(); index ++) {
        //   jenkinsfileParameter = jenkinsfileParameters.get(index).getArguments()
        //   defaultNamesParameters.add(jenkinsfileParameter.name)
        // }

        allParameters.addAll(jenkinsfileParameters)
      } else {
        prop.add(property)
    }
  }

  prop.add(
    parameters(
      allParameters
    )
  )

  properties(prop)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
