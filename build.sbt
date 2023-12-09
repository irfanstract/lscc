/* DO NOT USE BLOOP ! */

















import sbtcrossproject.CrossProject

import Build.mainly._

lazy val lscAlgLibProject
=
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "lscalg" ) )
  .asLeafProjectWithNecessarySettings()

lazy val main1
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main1" ) )
  .asLeafProjectWithNecessarySettings()
  .withDbp(mainClassNames = Some("runSMain") )
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(lscAlgLibProject )
  .withJavaUtilLocaleCQuiroz()













