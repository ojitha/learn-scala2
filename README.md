# learn-scala2

This project contains Scala 2 learning materials and blog posts for publication at https://ojitha.github.io.

## Blogs

The repository uses Jupyter notebooks with the Almond kernel to create interactive Scala 2 tutorials and examples. The notebooks are converted to Markdown format for publishing as blog posts.

## Requirements

- Python >= 3.9.6
- Jupyter
- Almond Scala kernel for Jupyter
- uv (Python package manager)

## Setup (VSCode with Scala + Metals)

1. Install Python dependencies:

   ```bash
   uv sync
   ```

2. Set up the Almond Scala kernel (if not already installed):

   ```bash
   cs bootstrap \
    -r jitpack \
    -i user -I user:sh.almond:scala-kernel-api_2.12.8:0.3.1 \
    sh.almond:scala-kernel_2.12.8:0.3.1 \
    --default=true --sources \
    -o almond

   # and install as a kernel
   ./almond --install --global
   ```
   or use the direct installation for latest such as:
   
   ```bash
   cs bootstrap almond:0.13.14 --scala 2.13.10 --sources -o almond
   ./almond --install --metabrowse
   ```

   In addition to that install the Metal Plugin to the VSCode

   > Followed the note https://github.com/alexarchambault/almond-examples/blob/89eed0ff78b0b1018154ec8b391afc48a6439999/notebooks/colab/install-almond.ipynb to install the Scala as a Kernel.

   To list the installed kernels

   ```bash
    uv run jupyter kernelspec list
   ```

   

## Usage
Use VSCode Jupyter plugin to create ipynb files and select the `Scala` as Kernel.

### Converting Notebooks to Markdown

The `blogs/Makefile` provides automation for converting Jupyter notebooks to Markdown:

```bash
cd blogs
make              # Convert all notebooks to markdown
make clean        # Remove generated markdown files
```

The conversion process:
- Sanitizes HTML content
- Removes cells tagged with 'remove_input' or 'remove_output'
- Extracts images to `./blogs/assets/images/<notebook-name>/`
- Cleans ANSI color codes from output
- Adjusts image paths for deployment

### Current Blog Posts

- **Scala Basics**: Introduction to Scala 2 fundamentals
- **Scala Collections**: Working with Scala collections

### Generate via Jupyter lab

```bash
make
cd ../../ojitha.github.io && make
cd ../learn-scala2/blogs
```

## License

See [LICENSE](LICENSE) for details.
