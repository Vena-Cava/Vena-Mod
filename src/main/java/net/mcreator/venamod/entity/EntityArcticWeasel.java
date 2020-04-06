
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
import net.minecraft.item.Item;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class EntityArcticWeasel extends ElementsVenaMod.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityArcticWeasel(ElementsVenaMod instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("venamod", "arcticweasel"), ENTITYID).name("arcticweasel").tracker(20, 3, true).egg(-1, -1644826).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("venamod:jolinplains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 10, 1, 3, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelArctic_Weasel(), 0.2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("venamod:textures/arctic_weasel.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityWolf {
		public EntityCustom(World world) {
			super(world);
			setSize(0.7999999999999999f, 0.4f);
			experienceValue = 2;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityRabbit.class, true, true));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.rabbit.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.rabbit.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.rabbit.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelArctic_Weasel extends ModelBase {
		private final ModelRenderer Head;
		private final ModelRenderer Torso;
		private final ModelRenderer Legs;
		private final ModelRenderer F_R_Leg;
		private final ModelRenderer F_L_Leg;
		private final ModelRenderer B_L_Leg;
		private final ModelRenderer B_R_Leg;
		private final ModelRenderer Tail;
		public ModelArctic_Weasel() {
			textureWidth = 32;
			textureHeight = 32;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 19.0F, -5.0F);
			Head.cubeList.add(new ModelBox(Head, 0, 0, -3.0F, -3.0F, -3.0F, 5, 4, 4, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 18, 0, -2.0F, -1.0F, -4.0F, 3, 2, 2, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 18, 4, -3.0F, -4.0F, -2.0F, 2, 2, 1, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 18, 4, 0.0F, -4.0F, -2.0F, 2, 2, 1, 0.0F, true));
			Torso = new ModelRenderer(this);
			Torso.setRotationPoint(0.0F, 19.0F, -5.0F);
			Torso.cubeList.add(new ModelBox(Torso, 0, 8, -2.0F, -1.0F, 0.0F, 3, 3, 9, 0.0F, false));
			Legs = new ModelRenderer(this);
			Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
			F_R_Leg = new ModelRenderer(this);
			F_R_Leg.setRotationPoint(-1.5F, -3.0F, -3.5F);
			Legs.addChild(F_R_Leg);
			F_R_Leg.cubeList.add(new ModelBox(F_R_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F, false));
			F_L_Leg = new ModelRenderer(this);
			F_L_Leg.setRotationPoint(0.5F, -3.0F, -3.5F);
			Legs.addChild(F_L_Leg);
			F_L_Leg.cubeList.add(new ModelBox(F_L_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F, true));
			B_L_Leg = new ModelRenderer(this);
			B_L_Leg.setRotationPoint(0.5F, -3.0F, 3.5F);
			Legs.addChild(B_L_Leg);
			B_L_Leg.cubeList.add(new ModelBox(B_L_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F, true));
			B_R_Leg = new ModelRenderer(this);
			B_R_Leg.setRotationPoint(-1.5F, -3.0F, 3.5F);
			Legs.addChild(B_R_Leg);
			B_R_Leg.cubeList.add(new ModelBox(B_R_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F, false));
			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.0F, 18.0F, 4.0F);
			setRotationAngle(Tail, -0.4363F, 0.0F, 0.0F);
			Tail.cubeList.add(new ModelBox(Tail, 2, 23, -1.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Head.render(f5);
			Torso.render(f5);
			Legs.render(f5);
			Tail.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.B_R_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.F_R_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.F_L_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.B_L_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
