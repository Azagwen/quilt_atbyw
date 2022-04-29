package net.azagwen.atbyw.datagen;

import com.google.common.collect.Maps;
import net.azagwen.atbyw.containers.AtbywContainer;
import net.azagwen.atbyw.AtbywMain;
import net.azagwen.atbyw.util.AtbywUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Map;

public class TagDatagen {
    public static Map<AtbywContainer<?>, Identifier> APPEND_TRACKER = Maps.newLinkedHashMap();

    @SafeVarargs
    public static <T> void appendToTag(Identifier tagId, Tag.Builder tagBuilder, TagKey<T> targetTag, AtbywContainer<T>... objectsToAdd) {
        var tempContainer = new AtbywContainer<T>("temp_container", objectsToAdd[0].type);
        for (var container : objectsToAdd) {
            tempContainer.addAll(container);
            for (var object : container){
                if (object instanceof Block block) {
                    addToTag(tagId, tagBuilder, targetTag, block);
                }
                if (object instanceof Item item) {
                    addToTag(tagId, tagBuilder, targetTag, item);
                }
            }
        }
        if (tagId.equals(targetTag.id())) {
            APPEND_TRACKER.put(tempContainer, targetTag.id());
        }
    }

    public static void addToTag(Identifier tagId, Tag.Builder tagBuilder, TagKey<?> tag, Object objectToAdd) {
        if (tagId.equals(tag.id())) {
            tagBuilder.add(AtbywUtils.getId(objectToAdd), AtbywMain.ATBYW);
        }
    }

    public static String buildLogMessage(String type, int count) {
        var message = "Added %1s additional %2s%3s to {}";
        return message.replace("%1s", String.valueOf(count)).replace("%2s", type).replace("%3s", count > 1 ? "s" : "");
    }

    public static void printAppendLogs() {
        TagDatagen.APPEND_TRACKER.forEach((container, identifier) -> {
            if (container.size() > 0){
                AtbywMain.LOGGER.info(TagDatagen.buildLogMessage(container.type, container.size()), identifier);
            }
        });
    }
}
