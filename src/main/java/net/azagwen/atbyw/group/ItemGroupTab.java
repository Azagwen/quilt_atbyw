package net.azagwen.atbyw.group;

import net.azagwen.atbyw.AtbywMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// This code was originally taken from https://github.com/Lemonszz/gubbins/blob/master/src/main/java/party/lemons/gubbins/itemgroup/ItemTab.java,
// which is licensed under MIT.
// and edited to match my needs & updated to 1.17.
public class ItemGroupTab {
    protected static final List<ItemGroupTab> TABS = new ArrayList<>();
    private final ItemStack icon;
    private final String name;
    private final List<Item> itemList;

    public ItemGroupTab(ItemStack icon, String name, List<Item> itemList) {
        this.icon = icon;
        this.name = name;
        this.itemList = itemList;
        TABS.add(this);
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public boolean matches(Item item) {
        return this.itemList == null || this.itemList.contains(item);
    }

    public boolean matches(ItemStack stack) {
        return matches(stack.getItem());
    }

    public List<Item> getItems() {
        return itemList;
    }

    public String getTranslationKey() {
        return "itemGroup.subTab." + AtbywMain.ATBYW + "." + name;
    }

    public ItemStack icon() {
        return this.icon;
    }

    public String name() {
        return this.name;
    }

    public List<Item> itemList() {
        return this.itemList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ItemGroupTab) obj;
        return Objects.equals(this.icon, that.icon) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.itemList, that.itemList);
    }

    @Override
    public String toString() {
        return String.format("ItemGroupTab[" + "icon= %s, name= %s, itemList= %s]", this.icon, this.name, this.itemList);
    }

}