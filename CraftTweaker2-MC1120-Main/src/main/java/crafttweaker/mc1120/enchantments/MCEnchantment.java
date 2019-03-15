package crafttweaker.mc1120.enchantments;

import crafttweaker.api.data.*;
import crafttweaker.api.enchantments.*;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.item.MCItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.*;

public class MCEnchantment implements IEnchantment {
    
    private final Enchantment definition;
    private int level;
    
    public MCEnchantment(int id, int lvl) {
        this(Enchantment.getEnchantmentByID(id), lvl);
    }
    
    public MCEnchantment(Enchantment enchantment, int level) {
        this.definition = enchantment;
        this.level = level;
    }
    
    @Override
    public IEnchantmentDefinition getDefinition() {
        return new MCEnchantmentDefinition(definition);
    }
    
    @Override
    public IData makeTag() {
        Map<String, IData> map = new HashMap<>();
        map.put("id", new DataShort((short) getDefinition().getID()));
        map.put("lvl", new DataShort((short) level));
        return new DataMap(Collections.singletonMap("ench", new DataList(Collections.singletonList(new DataMap(map, false)), false)), false);
    }

    @Override
    public IData makeBookTag () {
        Map<String, IData> map = new HashMap<>();
        map.put("id", new DataShort((short) getDefinition().getID()));
        map.put("lvl", new DataShort((short) level));
        return new DataMap(Collections.singletonMap("StoredEnchantments", new DataList(Collections.singletonList(new DataMap(map, false)), false)), false);
    }
    
    @Override
    public int getLevel() {
        return level;
    }
    
    @Override
    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public String displayName() {
        return definition.getTranslatedName(level);
    }
}
