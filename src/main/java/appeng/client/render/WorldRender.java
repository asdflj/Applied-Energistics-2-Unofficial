/*
 * This file is part of Applied Energistics 2. Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved. Applied
 * Energistics 2 is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version. Applied Energistics 2 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details. You should have received a copy of the GNU Lesser General Public License along with
 * Applied Energistics 2. If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.gtnewhorizons.angelica.api.ThreadSafeISBRH;

import appeng.block.AEBaseBlock;
import appeng.core.AELog;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@ThreadSafeISBRH(perThread = true)
public final class WorldRender implements ISimpleBlockRenderingHandler {

    public static final WorldRender INSTANCE = new WorldRender();
    private static final int renderID = RenderingRegistry.getNextAvailableRenderId();
    private final RenderBlocks renderer = new RenderBlocks();
    private boolean hasError = false;

    public WorldRender() {}

    @Override
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID,
            final RenderBlocks renderer) {
        // wtf is this for?
    }

    @Override
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block,
            final int modelId, final RenderBlocks renderer) {
        final AEBaseBlock blk = (AEBaseBlock) block;
        renderer.setRenderBoundsFromBlock(block);
        return this.getRender(blk).renderInWorld(blk, world, x, y, z, renderer);
    }

    @Override
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return this.renderID;
    }

    private BaseBlockRender getRender(final AEBaseBlock block) {
        return block.getRendererInstance().getRendererInstance();
    }

    void renderItemBlock(final ItemStack item, final ItemRenderType type, final Object[] data) {
        final Block blk = Block.getBlockFromItem(item.getItem());
        if (blk instanceof AEBaseBlock block) {
            this.renderer.setRenderBoundsFromBlock(block);

            this.renderer.uvRotateBottom = this.renderer.uvRotateEast = this.renderer.uvRotateNorth = this.renderer.uvRotateSouth = this.renderer.uvRotateTop = this.renderer.uvRotateWest = 0;
            this.getRender(block).renderInventory(block, item, this.renderer, type, data);
            this.renderer.uvRotateBottom = this.renderer.uvRotateEast = this.renderer.uvRotateNorth = this.renderer.uvRotateSouth = this.renderer.uvRotateTop = this.renderer.uvRotateWest = 0;
        } else {
            if (!this.hasError) {
                this.hasError = true;
                AELog.error("Invalid render - item/block mismatch");
                AELog.error("		item: " + item.getUnlocalizedName());
                AELog.error("		block: " + blk.getUnlocalizedName());
            }
        }
    }
}
