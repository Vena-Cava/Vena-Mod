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
		Head.cubeList.add(new ModelBox(Head, 0, 0, -3.0F, -3.0F, -3.0F, 5, 4,
				4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 18, 0, -2.0F, -1.0F, -4.0F, 3, 2,
				2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 18, 4, -3.0F, -4.0F, -2.0F, 2, 2,
				1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 18, 4, 0.0F, -4.0F, -2.0F, 2, 2,
				1, 0.0F, true));

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(0.0F, 19.0F, -5.0F);
		Torso.cubeList.add(new ModelBox(Torso, 0, 8, -2.0F, -1.0F, 0.0F, 3, 3,
				9, 0.0F, false));

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);

		F_R_Leg = new ModelRenderer(this);
		F_R_Leg.setRotationPoint(-1.5F, -3.0F, -3.5F);
		Legs.addChild(F_R_Leg);
		F_R_Leg.cubeList.add(new ModelBox(F_R_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1,
				3, 1, 0.0F, false));

		F_L_Leg = new ModelRenderer(this);
		F_L_Leg.setRotationPoint(0.5F, -3.0F, -3.5F);
		Legs.addChild(F_L_Leg);
		F_L_Leg.cubeList.add(new ModelBox(F_L_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1,
				3, 1, 0.0F, true));

		B_L_Leg = new ModelRenderer(this);
		B_L_Leg.setRotationPoint(0.5F, -3.0F, 3.5F);
		Legs.addChild(B_L_Leg);
		B_L_Leg.cubeList.add(new ModelBox(B_L_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1,
				3, 1, 0.0F, true));

		B_R_Leg = new ModelRenderer(this);
		B_R_Leg.setRotationPoint(-1.5F, -3.0F, 3.5F);
		Legs.addChild(B_R_Leg);
		B_R_Leg.cubeList.add(new ModelBox(B_R_Leg, 0, 8, -0.5F, 0.0F, -0.5F, 1,
				3, 1, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 18.0F, 4.0F);
		setRotationAngle(Tail, -0.4363F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 2, 23, -1.0F, 0.0F, 0.0F, 1, 1, 6,
				0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Head.render(f5);
		Torso.render(f5);
		Legs.render(f5);
		Tail.render(f5);
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
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.B_R_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.F_R_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.F_L_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.B_L_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}