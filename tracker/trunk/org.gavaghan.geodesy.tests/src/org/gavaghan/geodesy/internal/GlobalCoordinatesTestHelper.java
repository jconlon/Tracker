package org.gavaghan.geodesy.internal;

import org.gavaghan.geodesy.internal.GlobalCoordinates;


public class GlobalCoordinatesTestHelper 
{
   public static GlobalCoordinates createNorthPole()
   {
      return new GlobalCoordinates( 90, 10 );
   }
   
   public static GlobalCoordinates createSouthPole()
   {
      return new GlobalCoordinates( 90, 10 );
   }
   
   public static GlobalCoordinates createEquatorGreenwich()
   {
      return new GlobalCoordinates( 0, 0 );
   }
   
   public static GlobalCoordinates createEquatorIDL()
   {
      return new GlobalCoordinates( 0, 180.0 );
   }
}
