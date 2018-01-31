#!/usr/bin/env groovy
import hudson.model.StringParameterValue
// import hudson.model.StringParameterDefinition
// import hudson.model.ParametersDefinitionProperty
import hudson.model.ParametersAction
import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def execute() {
  // def newParam = new StringParameterDefinition('foo', 'var', 'mi variable')
  // def newArrList = []
  // newArrList.add(newParam)
  // def newParamDef = new ParametersDefinitionProperty(newArrList)

  // echo("=======> el nombre es: ${currentBuild.getProjectName()}")
  // currentBuild.addAction(newParamDef)
  def pa = new ParametersAction([
    new StringParameterValue("FOO", "BAR")
  ])
  currentBuild.addAction(pa)


  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
  }
}

return this
