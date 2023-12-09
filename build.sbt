/* DO NOT USE BLOOP ! */

















import sbtcrossproject.CrossProject

import Build.mainly._

lazy val lscAlgLibProject
=
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "lscalg" ) )
  .asLeafProjectWithNecessarySettings()

lazy val lscAnsioProject
=
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "lscoreansio" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(lscAlgLibProject )

lazy val kscProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "ksc" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(lscAlgLibProject )
  .dependsOn(lscAnsioProject )

lazy val main1
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main1" ) )
  .asLeafProjectWithNecessarySettings()
  /* as a main-app */
  .withDbp(mainClassNames = Some("runSMain") )
  .dependsOn(lscAlgLibProject )
  .dependsOn(lscAnsioProject )
  .dependsOn(kscProject )
  .withJavaUtilLocaleCQuiroz()













