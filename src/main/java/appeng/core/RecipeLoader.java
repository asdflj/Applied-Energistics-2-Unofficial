/*
 * This file is part of Applied Energistics 2. Copyright (c) 2013 - 2015, AlgorithmX2, All rights reserved. Applied
 * Energistics 2 is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version. Applied Energistics 2 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details. You should have received a copy of the GNU Lesser General Public License along with
 * Applied Energistics 2. If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.Nonnull;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;

import appeng.api.recipes.IRecipeHandler;
import appeng.recipes.CustomRecipeConfig;
import appeng.recipes.loader.ConfigLoader;
import appeng.recipes.loader.JarLoader;
import appeng.recipes.loader.RecipeResourceCopier;
import cpw.mods.fml.common.Loader;

/**
 * handles the decision if recipes should be loaded from jar, loaded from file system or force copied from jar
 *
 * @author thatsIch
 * @version rv3 - 12.05.2015
 * @since rv3 12.05.2015
 */
public class RecipeLoader implements Runnable {

    /**
     * recipe path in the jar
     */
    private static final String ASSETS_RECIPE_PATH = "/assets/appliedenergistics2/recipes/";
    private static final String ASSETS_GTNH_RECIPE_PATH = "/assets/appliedenergistics2/GTNHRecipes/";

    @Nonnull
    private final IRecipeHandler handler;

    @Nonnull
    private final CustomRecipeConfig config;

    @Nonnull
    private final File recipeDirectory;

    /**
     * @param config  configuration for the knowledge how to handle the loading process
     * @param handler handler to load the recipes
     * @throws NullPointerException if handler is <tt>null</tt>
     */
    public RecipeLoader(@Nonnull final File recipeDirectory, @Nonnull final CustomRecipeConfig config,
            @Nonnull final IRecipeHandler handler) {
        this.recipeDirectory = Preconditions.checkNotNull(recipeDirectory);
        Preconditions.checkArgument(!recipeDirectory.isFile());
        this.config = Preconditions.checkNotNull(config);
        this.handler = Preconditions.checkNotNull(handler);
    }

    @Override
    public final void run() {
        final String recipesFolder = Loader.isModLoaded("dreamcraft") ? ASSETS_GTNH_RECIPE_PATH : ASSETS_RECIPE_PATH;
        boolean useResourceFallBack = true;

        if (this.config.isEnabled()) {
            // setup copying
            final RecipeResourceCopier copier = new RecipeResourceCopier(recipesFolder.substring(1));

            final File generatedRecipesDir = new File(this.recipeDirectory, "generated");
            final File userRecipesDir = new File(this.recipeDirectory, "user");

            // generates generated and user recipes dir
            // will clean the generated every time to keep it up to date
            // copies over the recipes in the jar over to the generated folder
            // copies over the readmes
            try {
                FileUtils.forceMkdir(generatedRecipesDir);
                FileUtils.forceMkdir(userRecipesDir);
                FileUtils.cleanDirectory(generatedRecipesDir);

                copier.copyTo(".recipe", generatedRecipesDir);
                copier.copyTo(".html", this.recipeDirectory);

                // parse recipes prioritising the user scripts by using the generated as template
                this.handler.parseRecipes(new ConfigLoader(generatedRecipesDir, userRecipesDir), "index.recipe");

                useResourceFallBack = false;
            }
            // on failure use jar parsing
            catch (final IOException | URISyntaxException e) {
                AELog.debug(e);
            }
        }

        if (useResourceFallBack) {
            this.handler.parseRecipes(new JarLoader(recipesFolder), "index.recipe");
        }
    }
}
