node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/my_basicport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/my_basicport.git'), string(name: 'PORT_DESCRIPTION', value: 'MY-BASIC is a lightweight BASIC interpreter written in standard C in dual files.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
