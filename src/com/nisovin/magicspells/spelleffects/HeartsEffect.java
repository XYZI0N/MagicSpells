package com.nisovin.magicspells.spelleffects;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Tameable;

import de.slikey.effectlib.util.ParticleEffect;

class HeartsEffect extends SpellEffect {
	
	private ParticleEffect effect = ParticleEffect.HEART;
	
	private float yOffset = 2F;
	
	private double range = 32;
	private int count = 4;
	private float speed = .2F;
	private float spreadHoriz = .3F;
	private float spreadVert = .2F;
	
	@Override
	public void loadFromString(String string) {
	}

	@Override
	public void loadFromConfig(ConfigurationSection config) {
	}
	
	@Override
	public void playEffectEntity(Entity entity) {
		if (entity instanceof Tameable) {
			entity.playEffect(EntityEffect.WOLF_HEARTS);
		} else {
			playEffect(entity.getLocation());
		}
	}
	
	@Override
	public void playEffectLocation(Location location) {
		//MagicSpells.getVolatileCodeHandler().playParticleEffect(location, "heart", .3F, .2F, .2F, 4, 32, 2F);
		//Location location, String name, float spreadHoriz, float spreadVert, float speed, int count, int radius, float yOffset
		
		effect.display(null, location.add(0, yOffset, 0), null, range, spreadHoriz, spreadVert, spreadHoriz, speed, count);
		//ParticleData data, Location center, Color color, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount
	}
	
}
