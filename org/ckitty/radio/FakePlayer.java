package org.ckitty.radio;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class FakePlayer implements Player {
	
	protected Location loc;
	protected String name;
	
	public FakePlayer(String name, Location loc) {
		this.name = name;
		this.loc = loc;
	}
	
	public Location getLocationFromFake() {
		return this.loc;
	}
	
	public String getNameFromFake() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#closeInventory()
	 */
	@Override
	public void closeInventory() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getCooldown(org.bukkit.Material)
	 */
	@Override
	public int getCooldown(Material arg0) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getEnderChest()
	 */
	@Override
	public Inventory getEnderChest() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getExpToLevel()
	 */
	@Override
	public int getExpToLevel() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getGameMode()
	 */
	@Override
	public GameMode getGameMode() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getInventory()
	 */
	@Override
	public PlayerInventory getInventory() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getItemInHand()
	 */
	@Override
	public ItemStack getItemInHand() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getItemOnCursor()
	 */
	@Override
	public ItemStack getItemOnCursor() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getMainHand()
	 */
	@Override
	public MainHand getMainHand() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getOpenInventory()
	 */
	@Override
	public InventoryView getOpenInventory() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getShoulderEntityLeft()
	 */
	@Override
	public Entity getShoulderEntityLeft() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getShoulderEntityRight()
	 */
	@Override
	public Entity getShoulderEntityRight() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#getSleepTicks()
	 */
	@Override
	public int getSleepTicks() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#hasCooldown(org.bukkit.Material)
	 */
	@Override
	public boolean hasCooldown(Material arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#isBlocking()
	 */
	@Override
	public boolean isBlocking() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#isHandRaised()
	 */
	@Override
	public boolean isHandRaised() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#isSleeping()
	 */
	@Override
	public boolean isSleeping() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openEnchanting(org.bukkit.Location, boolean)
	 */
	@Override
	public InventoryView openEnchanting(Location arg0, boolean arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openInventory(org.bukkit.inventory.Inventory)
	 */
	@Override
	public InventoryView openInventory(Inventory arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openInventory(org.bukkit.inventory.InventoryView)
	 */
	@Override
	public void openInventory(InventoryView arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openMerchant(org.bukkit.entity.Villager, boolean)
	 */
	@Override
	public InventoryView openMerchant(Villager arg0, boolean arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openMerchant(org.bukkit.inventory.Merchant, boolean)
	 */
	@Override
	public InventoryView openMerchant(Merchant arg0, boolean arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#openWorkbench(org.bukkit.Location, boolean)
	 */
	@Override
	public InventoryView openWorkbench(Location arg0, boolean arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setCooldown(org.bukkit.Material, int)
	 */
	@Override
	public void setCooldown(Material arg0, int arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setGameMode(org.bukkit.GameMode)
	 */
	@Override
	public void setGameMode(GameMode arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setItemInHand(org.bukkit.inventory.ItemStack)
	 */
	@Override
	public void setItemInHand(ItemStack arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setItemOnCursor(org.bukkit.inventory.ItemStack)
	 */
	@Override
	public void setItemOnCursor(ItemStack arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setShoulderEntityLeft(org.bukkit.entity.Entity)
	 */
	@Override
	public void setShoulderEntityLeft(Entity arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setShoulderEntityRight(org.bukkit.entity.Entity)
	 */
	@Override
	public void setShoulderEntityRight(Entity arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.HumanEntity#setWindowProperty(org.bukkit.inventory.InventoryView.Property, int)
	 */
	@Override
	public boolean setWindowProperty(Property arg0, int arg1) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#addPotionEffect(org.bukkit.potion.PotionEffect)
	 */
	@Override
	public boolean addPotionEffect(PotionEffect arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#addPotionEffect(org.bukkit.potion.PotionEffect, boolean)
	 */
	@Override
	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#addPotionEffects(java.util.Collection)
	 */
	@Override
	public boolean addPotionEffects(Collection<PotionEffect> arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getActivePotionEffects()
	 */
	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getCanPickupItems()
	 */
	@Override
	public boolean getCanPickupItems() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getEquipment()
	 */
	@Override
	public EntityEquipment getEquipment() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getEyeHeight()
	 */
	@Override
	public double getEyeHeight() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getEyeHeight(boolean)
	 */
	@Override
	public double getEyeHeight(boolean arg0) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getEyeLocation()
	 */
	@Override
	public Location getEyeLocation() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getKiller()
	 */
	@Override
	public Player getKiller() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getLastDamage()
	 */
	@Override
	public double getLastDamage() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getLastTwoTargetBlocks(java.util.Set, int)
	 */
	@Override
	public List<Block> getLastTwoTargetBlocks(Set<Material> arg0, int arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getLeashHolder()
	 */
	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getLineOfSight(java.util.Set, int)
	 */
	@Override
	public List<Block> getLineOfSight(Set<Material> arg0, int arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getMaximumAir()
	 */
	@Override
	public int getMaximumAir() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getMaximumNoDamageTicks()
	 */
	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getNoDamageTicks()
	 */
	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getPotionEffect(org.bukkit.potion.PotionEffectType)
	 */
	@Override
	public PotionEffect getPotionEffect(PotionEffectType arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getRemainingAir()
	 */
	@Override
	public int getRemainingAir() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getRemoveWhenFarAway()
	 */
	@Override
	public boolean getRemoveWhenFarAway() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#getTargetBlock(java.util.Set, int)
	 */
	@Override
	public Block getTargetBlock(Set<Material> arg0, int arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#hasAI()
	 */
	@Override
	public boolean hasAI() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#hasLineOfSight(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean hasLineOfSight(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#hasPotionEffect(org.bukkit.potion.PotionEffectType)
	 */
	@Override
	public boolean hasPotionEffect(PotionEffectType arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#isCollidable()
	 */
	@Override
	public boolean isCollidable() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#isGliding()
	 */
	@Override
	public boolean isGliding() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#isLeashed()
	 */
	@Override
	public boolean isLeashed() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#removePotionEffect(org.bukkit.potion.PotionEffectType)
	 */
	@Override
	public void removePotionEffect(PotionEffectType arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setAI(boolean)
	 */
	@Override
	public void setAI(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setCanPickupItems(boolean)
	 */
	@Override
	public void setCanPickupItems(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setCollidable(boolean)
	 */
	@Override
	public void setCollidable(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setGliding(boolean)
	 */
	@Override
	public void setGliding(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setLastDamage(double)
	 */
	@Override
	public void setLastDamage(double arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setLeashHolder(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean setLeashHolder(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setMaximumAir(int)
	 */
	@Override
	public void setMaximumAir(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setMaximumNoDamageTicks(int)
	 */
	@Override
	public void setMaximumNoDamageTicks(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setNoDamageTicks(int)
	 */
	@Override
	public void setNoDamageTicks(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setRemainingAir(int)
	 */
	@Override
	public void setRemainingAir(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.LivingEntity#setRemoveWhenFarAway(boolean)
	 */
	@Override
	public void setRemoveWhenFarAway(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.attribute.Attributable#getAttribute(org.bukkit.attribute.Attribute)
	 */
	@Override
	public AttributeInstance getAttribute(Attribute arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#addPassenger(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean addPassenger(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#addScoreboardTag(java.lang.String)
	 */
	@Override
	public boolean addScoreboardTag(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#eject()
	 */
	@Override
	public boolean eject() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getEntityId()
	 */
	@Override
	public int getEntityId() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getFallDistance()
	 */
	@Override
	public float getFallDistance() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getFireTicks()
	 */
	@Override
	public int getFireTicks() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getHeight()
	 */
	@Override
	public double getHeight() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getLastDamageCause()
	 */
	@Override
	public EntityDamageEvent getLastDamageCause() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getLocation()
	 */
	@Override
	public Location getLocation() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getLocation(org.bukkit.Location)
	 */
	@Override
	public Location getLocation(Location arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getMaxFireTicks()
	 */
	@Override
	public int getMaxFireTicks() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getNearbyEntities(double, double, double)
	 */
	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getPassenger()
	 */
	@Override
	public Entity getPassenger() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getPassengers()
	 */
	@Override
	public List<Entity> getPassengers() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getPistonMoveReaction()
	 */
	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getPortalCooldown()
	 */
	@Override
	public int getPortalCooldown() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getScoreboardTags()
	 */
	@Override
	public Set<String> getScoreboardTags() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getServer()
	 */
	@Override
	public Server getServer() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getTicksLived()
	 */
	@Override
	public int getTicksLived() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getType()
	 */
	@Override
	public EntityType getType() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getUniqueId()
	 */
	@Override
	public UUID getUniqueId() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getVehicle()
	 */
	@Override
	public Entity getVehicle() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getVelocity()
	 */
	@Override
	public Vector getVelocity() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getWidth()
	 */
	@Override
	public double getWidth() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#getWorld()
	 */
	@Override
	public World getWorld() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#hasGravity()
	 */
	@Override
	public boolean hasGravity() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isCustomNameVisible()
	 */
	@Override
	public boolean isCustomNameVisible() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isDead()
	 */
	@Override
	public boolean isDead() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isGlowing()
	 */
	@Override
	public boolean isGlowing() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isInsideVehicle()
	 */
	@Override
	public boolean isInsideVehicle() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isInvulnerable()
	 */
	@Override
	public boolean isInvulnerable() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isOnGround()
	 */
	@Override
	public boolean isOnGround() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isSilent()
	 */
	@Override
	public boolean isSilent() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#isValid()
	 */
	@Override
	public boolean isValid() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#leaveVehicle()
	 */
	@Override
	public boolean leaveVehicle() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#playEffect(org.bukkit.EntityEffect)
	 */
	@Override
	public void playEffect(EntityEffect arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#remove()
	 */
	@Override
	public void remove() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#removePassenger(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean removePassenger(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#removeScoreboardTag(java.lang.String)
	 */
	@Override
	public boolean removeScoreboardTag(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setCustomNameVisible(boolean)
	 */
	@Override
	public void setCustomNameVisible(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setFallDistance(float)
	 */
	@Override
	public void setFallDistance(float arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setFireTicks(int)
	 */
	@Override
	public void setFireTicks(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setGlowing(boolean)
	 */
	@Override
	public void setGlowing(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setGravity(boolean)
	 */
	@Override
	public void setGravity(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setInvulnerable(boolean)
	 */
	@Override
	public void setInvulnerable(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setLastDamageCause(org.bukkit.event.entity.EntityDamageEvent)
	 */
	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setPassenger(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean setPassenger(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setPortalCooldown(int)
	 */
	@Override
	public void setPortalCooldown(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setSilent(boolean)
	 */
	@Override
	public void setSilent(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setTicksLived(int)
	 */
	@Override
	public void setTicksLived(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#setVelocity(org.bukkit.util.Vector)
	 */
	@Override
	public void setVelocity(Vector arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#teleport(org.bukkit.Location)
	 */
	@Override
	public boolean teleport(Location arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#teleport(org.bukkit.entity.Entity)
	 */
	@Override
	public boolean teleport(Entity arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#teleport(org.bukkit.Location, org.bukkit.event.player.PlayerTeleportEvent.TeleportCause)
	 */
	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Entity#teleport(org.bukkit.entity.Entity, org.bukkit.event.player.PlayerTeleportEvent.TeleportCause)
	 */
	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.metadata.Metadatable#getMetadata(java.lang.String)
	 */
	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.metadata.Metadatable#hasMetadata(java.lang.String)
	 */
	@Override
	public boolean hasMetadata(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.metadata.Metadatable#removeMetadata(java.lang.String, org.bukkit.plugin.Plugin)
	 */
	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.metadata.Metadatable#setMetadata(java.lang.String, org.bukkit.metadata.MetadataValue)
	 */
	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.command.CommandSender#sendMessage(java.lang.String)
	 */
	@Override
	public void sendMessage(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.command.CommandSender#sendMessage(java.lang.String[])
	 */
	@Override
	public void sendMessage(String[] arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#addAttachment(org.bukkit.plugin.Plugin)
	 */
	@Override
	public PermissionAttachment addAttachment(Plugin arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#addAttachment(org.bukkit.plugin.Plugin, int)
	 */
	@Override
	public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#addAttachment(org.bukkit.plugin.Plugin, java.lang.String, boolean)
	 */
	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#addAttachment(org.bukkit.plugin.Plugin, java.lang.String, boolean, int)
	 */
	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#getEffectivePermissions()
	 */
	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#hasPermission(java.lang.String)
	 */
	@Override
	public boolean hasPermission(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#hasPermission(org.bukkit.permissions.Permission)
	 */
	@Override
	public boolean hasPermission(Permission arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#isPermissionSet(java.lang.String)
	 */
	@Override
	public boolean isPermissionSet(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#isPermissionSet(org.bukkit.permissions.Permission)
	 */
	@Override
	public boolean isPermissionSet(Permission arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#recalculatePermissions()
	 */
	@Override
	public void recalculatePermissions() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.Permissible#removeAttachment(org.bukkit.permissions.PermissionAttachment)
	 */
	@Override
	public void removeAttachment(PermissionAttachment arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.ServerOperator#isOp()
	 */
	@Override
	public boolean isOp() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.permissions.ServerOperator#setOp(boolean)
	 */
	@Override
	public void setOp(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.Nameable#getCustomName()
	 */
	@Override
	public String getCustomName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.Nameable#setCustomName(java.lang.String)
	 */
	@Override
	public void setCustomName(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#damage(double)
	 */
	@Override
	public void damage(double arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#damage(double, org.bukkit.entity.Entity)
	 */
	@Override
	public void damage(double arg0, Entity arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#getHealth()
	 */
	@Override
	public double getHealth() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#getMaxHealth()
	 */
	@Override
	public double getMaxHealth() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#resetMaxHealth()
	 */
	@Override
	public void resetMaxHealth() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#setHealth(double)
	 */
	@Override
	public void setHealth(double arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Damageable#setMaxHealth(double)
	 */
	@Override
	public void setMaxHealth(double arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.projectiles.ProjectileSource#launchProjectile(java.lang.Class)
	 */
	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.projectiles.ProjectileSource#launchProjectile(java.lang.Class, org.bukkit.util.Vector)
	 */
	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.conversations.Conversable#abandonConversation(org.bukkit.conversations.Conversation)
	 */
	@Override
	public void abandonConversation(Conversation arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.conversations.Conversable#abandonConversation(org.bukkit.conversations.Conversation, org.bukkit.conversations.ConversationAbandonedEvent)
	 */
	@Override
	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.conversations.Conversable#acceptConversationInput(java.lang.String)
	 */
	@Override
	public void acceptConversationInput(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.conversations.Conversable#beginConversation(org.bukkit.conversations.Conversation)
	 */
	@Override
	public boolean beginConversation(Conversation arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.conversations.Conversable#isConversing()
	 */
	@Override
	public boolean isConversing() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#getFirstPlayed()
	 */
	@Override
	public long getFirstPlayed() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#getLastPlayed()
	 */
	@Override
	public long getLastPlayed() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#getPlayer()
	 */
	@Override
	public Player getPlayer() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#hasPlayedBefore()
	 */
	@Override
	public boolean hasPlayedBefore() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#isBanned()
	 */
	@Override
	public boolean isBanned() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#isOnline()
	 */
	@Override
	public boolean isOnline() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#isWhitelisted()
	 */
	@Override
	public boolean isWhitelisted() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.OfflinePlayer#setWhitelisted(boolean)
	 */
	@Override
	public void setWhitelisted(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.configuration.serialization.ConfigurationSerializable#serialize()
	 */
	@Override
	public Map<String, Object> serialize() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.plugin.messaging.PluginMessageRecipient#getListeningPluginChannels()
	 */
	@Override
	public Set<String> getListeningPluginChannels() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.plugin.messaging.PluginMessageRecipient#sendPluginMessage(org.bukkit.plugin.Plugin, java.lang.String, byte[])
	 */
	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#awardAchievement(org.bukkit.Achievement)
	 */
	@Override
	public void awardAchievement(Achievement arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#canSee(org.bukkit.entity.Player)
	 */
	@Override
	public boolean canSee(Player arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#chat(java.lang.String)
	 */
	@Override
	public void chat(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic)
	 */
	@Override
	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic, int)
	 */
	@Override
	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic, org.bukkit.Material)
	 */
	@Override
	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType)
	 */
	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic, org.bukkit.Material, int)
	 */
	@Override
	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#decrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType, int)
	 */
	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getAddress()
	 */
	@Override
	public InetSocketAddress getAddress() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getAdvancementProgress(org.bukkit.advancement.Advancement)
	 */
	@Override
	public AdvancementProgress getAdvancementProgress(Advancement arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getAllowFlight()
	 */
	@Override
	public boolean getAllowFlight() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getBedSpawnLocation()
	 */
	@Override
	public Location getBedSpawnLocation() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getCompassTarget()
	 */
	@Override
	public Location getCompassTarget() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getDisplayName()
	 */
	@Override
	public String getDisplayName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getExhaustion()
	 */
	@Override
	public float getExhaustion() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getExp()
	 */
	@Override
	public float getExp() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getFlySpeed()
	 */
	@Override
	public float getFlySpeed() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getFoodLevel()
	 */
	@Override
	public int getFoodLevel() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getHealthScale()
	 */
	@Override
	public double getHealthScale() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getLevel()
	 */
	@Override
	public int getLevel() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getLocale()
	 */
	@Override
	public String getLocale() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getPlayerListName()
	 */
	@Override
	public String getPlayerListName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getPlayerTime()
	 */
	@Override
	public long getPlayerTime() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getPlayerTimeOffset()
	 */
	@Override
	public long getPlayerTimeOffset() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getPlayerWeather()
	 */
	@Override
	public WeatherType getPlayerWeather() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getSaturation()
	 */
	@Override
	public float getSaturation() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getScoreboard()
	 */
	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getSpectatorTarget()
	 */
	@Override
	public Entity getSpectatorTarget() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getStatistic(org.bukkit.Statistic)
	 */
	@Override
	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getStatistic(org.bukkit.Statistic, org.bukkit.Material)
	 */
	@Override
	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType)
	 */
	@Override
	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getTotalExperience()
	 */
	@Override
	public int getTotalExperience() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#getWalkSpeed()
	 */
	@Override
	public float getWalkSpeed() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#giveExp(int)
	 */
	@Override
	public void giveExp(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#giveExpLevels(int)
	 */
	@Override
	public void giveExpLevels(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#hasAchievement(org.bukkit.Achievement)
	 */
	@Override
	public boolean hasAchievement(Achievement arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#hidePlayer(org.bukkit.entity.Player)
	 */
	@Override
	public void hidePlayer(Player arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#hidePlayer(org.bukkit.plugin.Plugin, org.bukkit.entity.Player)
	 */
	@Override
	public void hidePlayer(Plugin arg0, Player arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic)
	 */
	@Override
	public void incrementStatistic(Statistic arg0) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic, int)
	 */
	@Override
	public void incrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic, org.bukkit.Material)
	 */
	@Override
	public void incrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType)
	 */
	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic, org.bukkit.Material, int)
	 */
	@Override
	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType, int)
	 */
	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isFlying()
	 */
	@Override
	public boolean isFlying() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isHealthScaled()
	 */
	@Override
	public boolean isHealthScaled() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isPlayerTimeRelative()
	 */
	@Override
	public boolean isPlayerTimeRelative() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isSleepingIgnored()
	 */
	@Override
	public boolean isSleepingIgnored() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isSneaking()
	 */
	@Override
	public boolean isSneaking() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#isSprinting()
	 */
	@Override
	public boolean isSprinting() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#kickPlayer(java.lang.String)
	 */
	@Override
	public void kickPlayer(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#loadData()
	 */
	@Override
	public void loadData() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#performCommand(java.lang.String)
	 */
	@Override
	public boolean performCommand(String arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playEffect(org.bukkit.Location, org.bukkit.Effect, int)
	 */
	@Override
	public void playEffect(Location arg0, Effect arg1, int arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playEffect(org.bukkit.Location, org.bukkit.Effect, java.lang.Object)
	 */
	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playNote(org.bukkit.Location, byte, byte)
	 */
	@Override
	public void playNote(Location arg0, byte arg1, byte arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playNote(org.bukkit.Location, org.bukkit.Instrument, org.bukkit.Note)
	 */
	@Override
	public void playNote(Location arg0, Instrument arg1, Note arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playSound(org.bukkit.Location, org.bukkit.Sound, float, float)
	 */
	@Override
	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playSound(org.bukkit.Location, java.lang.String, float, float)
	 */
	@Override
	public void playSound(Location arg0, String arg1, float arg2, float arg3) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playSound(org.bukkit.Location, org.bukkit.Sound, org.bukkit.SoundCategory, float, float)
	 */
	@Override
	public void playSound(Location loc, Sound arg1, SoundCategory arg2, float arg3, float arg4) {
		// TODO
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#playSound(org.bukkit.Location, java.lang.String, org.bukkit.SoundCategory, float, float)
	 */
	@Override
	public void playSound(Location arg0, String arg1, SoundCategory arg2, float arg3, float arg4) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#removeAchievement(org.bukkit.Achievement)
	 */
	@Override
	public void removeAchievement(Achievement arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#resetPlayerTime()
	 */
	@Override
	public void resetPlayerTime() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#resetPlayerWeather()
	 */
	@Override
	public void resetPlayerWeather() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#resetTitle()
	 */
	@Override
	public void resetTitle() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#saveData()
	 */
	@Override
	public void saveData() {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte)
	 */
	@Override
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendBlockChange(org.bukkit.Location, int, byte)
	 */
	@Override
	public void sendBlockChange(Location arg0, int arg1, byte arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendChunkChange(org.bukkit.Location, int, int, int, byte[])
	 */
	@Override
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendMap(org.bukkit.map.MapView)
	 */
	@Override
	public void sendMap(MapView arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendRawMessage(java.lang.String)
	 */
	@Override
	public void sendRawMessage(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendSignChange(org.bukkit.Location, java.lang.String[])
	 */
	@Override
	public void sendSignChange(Location arg0, String[] arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendTitle(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendTitle(String arg0, String arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#sendTitle(java.lang.String, java.lang.String, int, int, int)
	 */
	@Override
	public void sendTitle(String arg0, String arg1, int arg2, int arg3, int arg4) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setAllowFlight(boolean)
	 */
	@Override
	public void setAllowFlight(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setBedSpawnLocation(org.bukkit.Location)
	 */
	@Override
	public void setBedSpawnLocation(Location arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setBedSpawnLocation(org.bukkit.Location, boolean)
	 */
	@Override
	public void setBedSpawnLocation(Location arg0, boolean arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setCompassTarget(org.bukkit.Location)
	 */
	@Override
	public void setCompassTarget(Location arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setDisplayName(java.lang.String)
	 */
	@Override
	public void setDisplayName(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setExhaustion(float)
	 */
	@Override
	public void setExhaustion(float arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setExp(float)
	 */
	@Override
	public void setExp(float arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setFlySpeed(float)
	 */
	@Override
	public void setFlySpeed(float arg0) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setFlying(boolean)
	 */
	@Override
	public void setFlying(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setFoodLevel(int)
	 */
	@Override
	public void setFoodLevel(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setHealthScale(double)
	 */
	@Override
	public void setHealthScale(double arg0) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setHealthScaled(boolean)
	 */
	@Override
	public void setHealthScaled(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setLevel(int)
	 */
	@Override
	public void setLevel(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setPlayerListName(java.lang.String)
	 */
	@Override
	public void setPlayerListName(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setPlayerTime(long, boolean)
	 */
	@Override
	public void setPlayerTime(long arg0, boolean arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setPlayerWeather(org.bukkit.WeatherType)
	 */
	@Override
	public void setPlayerWeather(WeatherType arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setResourcePack(java.lang.String)
	 */
	@Override
	public void setResourcePack(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setResourcePack(java.lang.String, byte[])
	 */
	@Override
	public void setResourcePack(String arg0, byte[] arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setSaturation(float)
	 */
	@Override
	public void setSaturation(float arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setScoreboard(org.bukkit.scoreboard.Scoreboard)
	 */
	@Override
	public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setSleepingIgnored(boolean)
	 */
	@Override
	public void setSleepingIgnored(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setSneaking(boolean)
	 */
	@Override
	public void setSneaking(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setSpectatorTarget(org.bukkit.entity.Entity)
	 */
	@Override
	public void setSpectatorTarget(Entity arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setSprinting(boolean)
	 */
	@Override
	public void setSprinting(boolean arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setStatistic(org.bukkit.Statistic, int)
	 */
	@Override
	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setStatistic(org.bukkit.Statistic, org.bukkit.Material, int)
	 */
	@Override
	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType, int)
	 */
	@Override
	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setTexturePack(java.lang.String)
	 */
	@Override
	public void setTexturePack(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setTotalExperience(int)
	 */
	@Override
	public void setTotalExperience(int arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#setWalkSpeed(float)
	 */
	@Override
	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#showPlayer(org.bukkit.entity.Player)
	 */
	@Override
	public void showPlayer(Player arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#showPlayer(org.bukkit.plugin.Plugin, org.bukkit.entity.Player)
	 */
	@Override
	public void showPlayer(Plugin arg0, Player arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int)
	 */
	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, T arg3) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int)
	 */
	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, T arg5) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int, double, double, double)
	 */
	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int, double, double, double, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			T arg6) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int, double, double, double, double)
	 */
	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			double arg6) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int, double, double, double)
	 */
	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6,
			double arg7) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, org.bukkit.Location, int, double, double, double, double, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			double arg6, T arg7) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int, double, double, double, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5,
			double arg6, double arg7, T arg8) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int, double, double, double, double)
	 */
	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6,
			double arg7, double arg8) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spawnParticle(org.bukkit.Particle, double, double, double, int, double, double, double, double, java.lang.Object)
	 */
	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5,
			double arg6, double arg7, double arg8, T arg9) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#spigot()
	 */
	@Override
	public Spigot spigot() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#stopSound(org.bukkit.Sound)
	 */
	@Override
	public void stopSound(Sound arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#stopSound(java.lang.String)
	 */
	@Override
	public void stopSound(String arg0) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#stopSound(org.bukkit.Sound, org.bukkit.SoundCategory)
	 */
	@Override
	public void stopSound(Sound arg0, SoundCategory arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#stopSound(java.lang.String, org.bukkit.SoundCategory)
	 */
	@Override
	public void stopSound(String arg0, SoundCategory arg1) {
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Player#updateInventory()
	 */
	@Override
	public void updateInventory() {
	}

}
