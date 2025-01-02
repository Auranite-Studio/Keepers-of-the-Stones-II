
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.esmods.keepersofthestonestwo.client.model.Modelturret_projectile;
import com.esmods.keepersofthestonestwo.client.model.Modelsolar_salvo;
import com.esmods.keepersofthestonestwo.client.model.Modelsmoke_bomb;
import com.esmods.keepersofthestonestwo.client.model.Modelrain_drop;
import com.esmods.keepersofthestonestwo.client.model.Modelpoisonous_thorn;
import com.esmods.keepersofthestonestwo.client.model.Modelpoison_bomb;
import com.esmods.keepersofthestonestwo.client.model.Modelmini_tornado;
import com.esmods.keepersofthestonestwo.client.model.Modelmeteorite;
import com.esmods.keepersofthestonestwo.client.model.Modellightball;
import com.esmods.keepersofthestonestwo.client.model.Modelknife;
import com.esmods.keepersofthestonestwo.client.model.Modeliceberg;
import com.esmods.keepersofthestonestwo.client.model.Modelgrenade;
import com.esmods.keepersofthestonestwo.client.model.Modelether_bullet;
import com.esmods.keepersofthestonestwo.client.model.Modelblock_attack;
import com.esmods.keepersofthestonestwo.client.model.Modelatomic_rocket;
import com.esmods.keepersofthestonestwo.client.model.ModelCrossed;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PowerModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmeteorite.LAYER_LOCATION, Modelmeteorite::createBodyLayer);
		event.registerLayerDefinition(Modelblock_attack.LAYER_LOCATION, Modelblock_attack::createBodyLayer);
		event.registerLayerDefinition(Modelpoison_bomb.LAYER_LOCATION, Modelpoison_bomb::createBodyLayer);
		event.registerLayerDefinition(Modelether_bullet.LAYER_LOCATION, Modelether_bullet::createBodyLayer);
		event.registerLayerDefinition(Modelgrenade.LAYER_LOCATION, Modelgrenade::createBodyLayer);
		event.registerLayerDefinition(ModelCrossed.LAYER_LOCATION, ModelCrossed::createBodyLayer);
		event.registerLayerDefinition(Modelrain_drop.LAYER_LOCATION, Modelrain_drop::createBodyLayer);
		event.registerLayerDefinition(Modelsmoke_bomb.LAYER_LOCATION, Modelsmoke_bomb::createBodyLayer);
		event.registerLayerDefinition(Modellightball.LAYER_LOCATION, Modellightball::createBodyLayer);
		event.registerLayerDefinition(Modelpoisonous_thorn.LAYER_LOCATION, Modelpoisonous_thorn::createBodyLayer);
		event.registerLayerDefinition(Modelmini_tornado.LAYER_LOCATION, Modelmini_tornado::createBodyLayer);
		event.registerLayerDefinition(Modelatomic_rocket.LAYER_LOCATION, Modelatomic_rocket::createBodyLayer);
		event.registerLayerDefinition(Modelturret_projectile.LAYER_LOCATION, Modelturret_projectile::createBodyLayer);
		event.registerLayerDefinition(Modelsolar_salvo.LAYER_LOCATION, Modelsolar_salvo::createBodyLayer);
		event.registerLayerDefinition(Modeliceberg.LAYER_LOCATION, Modeliceberg::createBodyLayer);
		event.registerLayerDefinition(Modelknife.LAYER_LOCATION, Modelknife::createBodyLayer);
	}
}
