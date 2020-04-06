
package net.mcreator.venamod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class EntityElf extends ElementsVenaMod.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityElf(ElementsVenaMod instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("venamod", "elf"), ENTITYID)
				.name("elf").tracker(64, 3, true).egg(-2444916, -11388115).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("venamod:jolinplains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 5, 20, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelElf(), 0.3f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("venamod:textures/elf-female.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 1.5f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 0.8));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.GOLD_NUGGET, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public EntityCustom createChild(EntityAgeable ageable) {
			return new EntityCustom(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			return false;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelElf extends ModelBase {
		private final ModelRenderer Arms;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer Legs;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer Torso;
		private final ModelRenderer Head;
		public ModelElf() {
			textureWidth = 64;
			textureHeight = 64;
			Arms = new ModelRenderer(this);
			Arms.setRotationPoint(0.0F, 24.0F, 0.0F);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-4.0F, -14.0F, 0.0F);
			Arms.addChild(RightArm);
			RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F, -2.0F, 3, 8, 4, 0.0F, false));
			RightArm.cubeList.add(new ModelBox(RightArm, 40, 31, -3.0F, -2.0F, -2.0F, 3, 8, 4, 0.3F, false));
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(4.0F, -14.0F, 0.0F);
			Arms.addChild(LeftArm);
			LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, 0.0F, -2.0F, -2.0F, 3, 8, 4, 0.0F, false));
			LeftArm.cubeList.add(new ModelBox(LeftArm, 48, 48, 0.0F, -2.0F, -2.0F, 3, 8, 4, 0.3F, false));
			Legs = new ModelRenderer(this);
			Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(0.0F, -8.0F, 0.0F);
			Legs.addChild(RightLeg);
			RightLeg.cubeList.add(new ModelBox(RightLeg, 16, 48, -4.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, false));
			RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 48, -4.0F, 0.0F, -2.0F, 4, 8, 4, 0.3F, false));
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(0.0F, -8.0F, 0.0F);
			Legs.addChild(LeftLeg);
			LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 16, 0.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, false));
			LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 32, 0.0F, 0.0F, -2.0F, 4, 8, 4, 0.3F, false));
			Torso = new ModelRenderer(this);
			Torso.setRotationPoint(0.0F, 24.0F, 0.0F);
			Torso.cubeList.add(new ModelBox(Torso, 16, 16, -4.0F, -16.0F, -2.0F, 8, 8, 4, 0.0F, false));
			Torso.cubeList.add(new ModelBox(Torso, 16, 28, -4.0F, -16.0F, -2.0F, 8, 8, 4, 0.31F, false));
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 8.0F, 0.0F);
			Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.3F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Arms.render(f5);
			Legs.render(f5);
			Torso.render(f5);
			Head.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
