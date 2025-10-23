{%- extends 'markdown/index.md.j2' -%}

{#- Wrap stream outputs (print, println, System.out) -#}
{% block stream %}
{{ output.text | strip_ansi | trim }}
{% endblock stream %}

{#- Wrap plain text data outputs (used in both execute_result and display_data) -#}
{% block data_text scoped %}
{{ output.data['text/plain'] | strip_ansi | trim }}
{% endblock data_text %}

{#- Keep the default behavior for images -#}
{% block data_png %}
{{ super() }}
{% endblock data_png %}

{% block data_jpg %}
{{ super() }}
{% endblock data_jpg %}

{% block data_svg %}
{{ super() }}
{% endblock data_svg %}

{#- Wrap error outputs (Scala exceptions, compilation errors) -#}
{% block error %}
{{ super() }}
{% endblock error %}