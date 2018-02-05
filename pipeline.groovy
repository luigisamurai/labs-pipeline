#!/usr/bin/env groovy
import hudson.model.ParametersDefinitionProperty
import hudson.model.JobProperty

def execute(pipelineProperties) {

  // print "====> Symbol: " + pipelineProperties[0].getSymbol()
  // print "====> getKlass: " + pipelineProperties[0].getKlass()
  // print "====> getModel: " + pipelineProperties[0].getModel()
  // print "====> getArguments: " + pipelineProperties[0].getArguments().values()
  // print "====> toMap: " + pipelineProperties[0].toMap().get("@parameters")

  // Set set = pipelineProperties[0].getArguments().entrySet()
  // Iterator iterator = set.iterator()

  // while(iterator.hasNext()) {
  //   Map.Entry me = (Map.Entry)iterator.next();
  //   println "Key is: "+ me.getKey() +  "& Value is: "+me.getValue();
  // }

  def defaultParameters =  [
      string(
      name: 'CUSTOM',
      description: 'Pipeline Environment Config key',
      defaultValue: 'CUSTOM---..'
    ),
    string(
      name: 'OTRO',
      description: 'OTRO',
      defaultValue: 'OTRO---..'
    )
  ]
  // def prop = []
  def allParameters = pipelineProperties[0].getArguments().get('<anonymous>')
  allParameters.addAll(defaultParameters)
  // prop.addAll(parameters)

  // for (ParametersDefinitionProperty property in pipelineProperties) {
  //     if (property.toString().startsWith("@parameters")) {
  //       parameters = pipelineProperties[0].getArguments().get('<anonymous>')
  //       parameters.add(customParam)
  //       println parameters
      
  //     } else {
  //       prop.add(property)
  //   }
  // }

  // properties(prop)

  properties([
    parameters(
      allParameters
    )
  ])

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
