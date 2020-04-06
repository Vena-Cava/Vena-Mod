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
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F,
				-2.0F, 3, 8, 4, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 31, -3.0F, -2.0F,
				-2.0F, 3, 8, 4, 0.3F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(4.0F, -14.0F, 0.0F);
		Arms.addChild(LeftArm);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, 0.0F, -2.0F, -2.0F,
				3, 8, 4, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 48, 48, 0.0F, -2.0F, -2.0F,
				3, 8, 4, 0.3F, false));

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, -8.0F, 0.0F);
		Legs.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 16, 48, -4.0F, 0.0F,
				-2.0F, 4, 8, 4, 0.0F, false));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 48, -4.0F, 0.0F, -2.0F,
				4, 8, 4, 0.3F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, -8.0F, 0.0F);
		Legs.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 16, 0.0F, 0.0F, -2.0F, 4,
				8, 4, 0.0F, false));
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 32, 0.0F, 0.0F, -2.0F, 4,
				8, 4, 0.3F, false));

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(0.0F, 24.0F, 0.0F);
		Torso.cubeList.add(new ModelBox(Torso, 16, 16, -4.0F, -16.0F, -2.0F, 8,
				8, 4, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 16, 28, -4.0F, -16.0F, -2.0F, 8,
				8, 4, 0.31F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 8.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8,
				8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8,
				8, 0.3F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Arms.render(f5);
		Legs.render(f5);
		Torso.render(f5);
		Head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}