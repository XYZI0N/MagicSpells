package com.nisovin.magicspells.spelleffects;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import de.slikey.effectlib.util.ParticleEffect;

class ParticlesEffect extends SpellEffect {
	
	ParticleEffect effect;
	String name = "explode";
	float horizSpread = 0.2F;
	float vertSpread = 0.2F;
	float speed = 0.2F;
	int count = 5;
	float yOffset = 0F;
	int renderDistance = 32;
	Color color = null;

	@Override
	public void loadFromString(String string) {
		if (string != null && !string.isEmpty()) {
			String[] data = string.split(" ");
			
			if (data.length >= 1) {
				name = data[0];
			}
			if (data.length >= 2) {
				horizSpread = Float.parseFloat(data[1]);
			}
			if (data.length >= 3) {
				vertSpread = Float.parseFloat(data[2]);
			}
			if (data.length >= 4) {
				speed = Float.parseFloat(data[3]);
			}
			if (data.length >= 5) {
				count = Integer.parseInt(data[4]);
			}
			if (data.length >= 6) {
				yOffset = Float.parseFloat(data[5]);
			}
			
			//TODO load the colors from the string
		}
		findEffect();
	}

	@Override
	public void loadFromConfig(ConfigurationSection config) {
		name = config.getString("particle-name", name);
		horizSpread = (float)config.getDouble("horiz-spread", horizSpread);
		vertSpread = (float)config.getDouble("vert-spread", vertSpread);
		speed = (float)config.getDouble("speed", speed);
		count = config.getInt("count", count);
		yOffset = (float)config.getDouble("y-offset", yOffset);
		renderDistance = config.getInt("render-distance", renderDistance);
		//TODO load colors
		findEffect();
	}
	
	protected void findEffect() {
		effect = ParticleEffect.fromName(name);
		if (effect == null) {
			throw new NullPointerException("No particle could be found from: \"" + name + "\"");
		}
	}

	@Override
	public void playEffectLocation(Location location) {
		//ParticleData data, Location center, Color color, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount
		effect.display(null, location.add(0, yOffset, 0), color, renderDistance, horizSpread, vertSpread, horizSpread, speed, count);
	}
	
}
