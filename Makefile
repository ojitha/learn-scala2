blogsDir := blogs
blogsSources := 2025-07-25-Scala-basics \
	2025-07-25-Scala-Collections 

source += $(foreach jupfile,$(blogsSources), $(blogsDir)/$(jupfile))

files := $(foreach wrd,$(source),$(wrd).md)
all: $(files)

# Function to create ipynb --> md
define make-markdown
$2/$1.md : $2/$1.ipynb
	@echo "-------------------------"
	@echo "Converting $$< -> $$@"
	@echo "-------------------------"
	uv run jupyter nbconvert --HTMLExporter.sanitize_html=true $$< --to markdown \
		--TagRemovePreprocessor.remove_input_tags="['remove_input','remove_output']" \
		--NbConvertApp.output_files_dir=./assets/images/$1 \
		--ExtractOutputPreprocessor.output_filename_template='fig_{index}{extension}'
		
	sed -i '' -E 's/\x1B\[[0-9;]*[mK]//g' $$@
	sed -i '' -E 's/\(\.\/assets/\(\/assets/g' $$@
endef

# Generate the rules for each source file
$(foreach element,$(blogsSources),$(eval $(call make-markdown,$(element),$(blogsDir))))

cleanmarkdown = $(shell rm $2/$1.md)	

# Clean target
clean:
	@echo "cleaning ..."
	$(foreach element,$(blogsSources),$(eval $(call cleanmarkdown,$(element),$(blogsDir))))

