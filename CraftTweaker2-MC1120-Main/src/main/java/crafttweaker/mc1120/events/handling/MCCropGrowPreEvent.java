package crafttweaker.mc1120.events.handling;

import crafttweaker.api.event.CropGrowPreEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class MCCropGrowPreEvent extends MCBlockEvent implements CropGrowPreEvent {
  private BlockEvent.CropGrowEvent.Pre event;

  public MCCropGrowPreEvent(BlockEvent.CropGrowEvent.Pre event) {
    super(event);
    this.event = event;
  }

  @Override
  public boolean isDenied() {
    return event.getResult() == Event.Result.DENY;
  }

  @Override
  public boolean isDefault() {
    return event.getResult() == Event.Result.DEFAULT;
  }

  @Override
  public boolean isAllowed() {
    return event.getResult() == Event.Result.ALLOW;
  }

  @Override
  public void setDenied() {
    event.setResult(Event.Result.DENY);
  }

  @Override
  public void setDefault() {
    event.setResult(Event.Result.DEFAULT);
  }

  @Override
  public void setAllowed() {
    event.setResult(Event.Result.ALLOW);
  }
}
