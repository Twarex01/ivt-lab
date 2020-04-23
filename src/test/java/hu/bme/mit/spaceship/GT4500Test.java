package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primary;
  private TorpedoStore secondary;

  @BeforeEach
  public void init(){
    primary = mock(TorpedoStore.class);
    secondary = mock(TorpedoStore.class);
    this.ship = new GT4500(primary, secondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    // Assert
    verify(primary, times(1)).fire(1);
    verify(secondary, times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.ALL);
    // Assert
    verify(primary, times(1)).fire(1);
    verify(secondary, times(1)).fire(1);
  }

  @Test
  public void test1_Single_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);
    // Assert
    verify(primary, times(1)).fire(1);
    verify(secondary, times(1)).fire(1);
  }

  @Test
  public void test2_Single_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    // Assert
    verify(primary, times(0)).fire(1);
    verify(secondary, times(1)).fire(1);
  }

  @Test
  public void test3_Single_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(true);
    when(secondary.isEmpty()).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.ALL);
    // Assert
    verify(primary, times(0)).fire(1);
    verify(secondary, times(0)).fire(1);
  }

  @Test
  public void test4_Single_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(true);
    when(secondary.isEmpty()).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    // Assert
    verify(primary, times(0)).fire(1);
    verify(secondary, times(0)).fire(1);
  }

  @Test
  public void test5_Single_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(false);
    when(secondary.isEmpty()).thenReturn(true);
    when(primary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);
    // Assert
    verify(primary, times(2)).fire(1);
    verify(secondary, times(0)).fire(1);
  }


}
